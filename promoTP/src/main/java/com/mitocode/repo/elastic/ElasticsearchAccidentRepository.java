package com.mitocode.repo.elastic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.mitocode.model.persistence.Accident;

import org.springframework.data.elasticsearch.annotations.Query;

// Los ElasticsearchRepository aparentemente no sopartan el uso del tipo de retorno Slice, por lo que se 
// tuvo que usar Page en sus consultas. 
public interface ElasticsearchAccidentRepository extends ElasticsearchRepository<Accident, String> {
    
    @Query("{\r\n"
    		+ "        \"bool\" : {\r\n"
    		+ "            \"must\" : {\r\n"
    		+ "                \"match_all\" : {}\r\n"
    		+ "            },\r\n"
    		+ "            \"filter\" : {\r\n"
    		+ "                \"geo_distance\" : {\r\n"
    		+ "                    \"distance\" : \"?2km\",\r\n"
    		+ "                    \"location\" : {\r\n"
    		+ "                        \"lat\" : ?0,\r\n"
    		+ "                        \"lon\" : ?1\r\n"
    		+ "                    }\r\n"
    		+ "                }\r\n"
    		+ "            }\r\n"
    		+ "        }\r\n"
    		+ "    }")
    Page<Accident> accidentsNearAPointInARadius(Double lat, Double lng, int radius, Pageable pageable);
    
    // Fechas en formato yyyy-MM-dd HH:mm:ss
    @Query("{\r\n"
    		+ "    \"range\": {\r\n"
    		+ "      \"start_time\": {\r\n"
    		+ "        \"gte\": \"?0\",\r\n"
    		+ "        \"lt\": \"?1\"\r\n"
    		+ "      }\r\n"
    		+ "    }\r\n"
    		+ "  }")
    Page<Accident> findByStartTimeBetween(String startDate, String endDate, Pageable pageable);

}