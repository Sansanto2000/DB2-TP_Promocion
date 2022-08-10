package com.mitocode.repo.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Accident;

@Repository
public interface IMongoAccidentRepo extends MongoRepository<Accident, String> {

	
	//No se si la anotattions @Add es correcta
	@Modifying("{$set: {location: { \"type\": \"Point\", \"coordinates\": [\"$Start_Lng\", \"$Start_Lat\"]}}}")
	void addLocationToAccidents();
	
	@Query("{location:{$near:{$geometry:{type:'Point',coordinates:?0},$maxDistance: ?1,$minDistance:1}}}")
    List<Accident> accidentsNearAPointInARadius(Double[] point, int radius, Pageable pageable);
	
	
}
