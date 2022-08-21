package com.mitocode.repo.mongo;

import com.mitocode.model.Accident;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;
import com.mitocode.model.LocationAndAmount;

@Repository
public interface IMongoAccidentRepo extends MongoRepository<Accident, String> {
	
	@Query("{location:{$near:{$geometry:{type:'Point',coordinates:?0},$maxDistance: ?1,$minDistance:0}}}")
    //@Query("{ \"location\" : { $eq : {type:\"Point\", coordinates:[-84.058723,39.865147]}}}")
    //Slice<Accident> accidentsNearAPointInARadius(Double[] point, int radius, Pageable pageable);
    Slice<Accident> accidentsNearAPointInARadius(Double[] point, int radius, Pageable pageable);
	
	@Aggregation(pipeline = {
            "{$geoNear: {near: { type: 'Point', coordinates: ?0 },distanceField: 'dist.calculated',maxDistance: ?1, spherical: true}}",
            "{$group : {_id: '$location', amount: {$sum: 1}}}",
            "{$sort: {amount:-1}}",
            "{$limit : 5}",
            "{$project: { '_id': 0, 'location':'$_id.coordinates', 'amount':'$amount'}}"
    })
    List<LocationAndAmount> fiveMostDangerousPoints(Double[] point, int radius);
}
