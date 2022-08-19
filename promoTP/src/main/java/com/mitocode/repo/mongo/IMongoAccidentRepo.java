package com.mitocode.repo.mongo;

import com.mitocode.model.Accident;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

@Repository
public interface IMongoAccidentRepo extends MongoRepository<Accident, String> {

	
	//No se si la anotattions @Add es correcta
	@Modifying
	@Query("{$set: {location: { \"type\": \"Point\", \"coordinates\": [\"$Start_Lng\", \"$Start_Lat\"]}}}")
	void addLocationToAccidents();
	
	@Query("{location:{$near:{$geometry:{type:'Point',coordinates:?0},$maxDistance: ?1,$minDistance:1}}}")
    Slice<Accident> accidentsNearAPointInARadius(Double[] point, int radius, Pageable pageable);
	
	
}
