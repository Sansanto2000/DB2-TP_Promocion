package com.mitocode.repo.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

import com.mitocode.model.persistence.Accident;
import com.mitocode.model.schema.AccidentWithDistanceSchema;
import com.mitocode.model.schema.LocationAndAmountSchema;

@Repository
public interface IMongoAccidentRepo extends MongoRepository<Accident, String> {
	
	@Query("{location:{$near:{$geometry:{type:'Point',coordinates:?0},$maxDistance: ?1, $minDistance:0}}}")
    Slice<Accident> accidentsNearAPointInARadius(Double[] point, int radius, Pageable pageable);
	
	@Aggregation(pipeline = {
            "{$geoNear: {near: { type: 'Point', coordinates: ?0 },distanceField: 'dist.calculated', maxDistance: ?1, spherical: true}}",
            "{$group : {_id: '$location', amount: {$sum: 1}}}",
            "{$sort: {amount:-1}}",
            "{$limit : 5}",
            "{$project: { '_id': 0, 'location':'$_id.coordinates', 'amount':'$amount'}}"
    })
    List<LocationAndAmountSchema> fiveMostDangerousPoints(Double[] point, int radius);
	
    @Aggregation(pipeline = {
            "{ $geoNear: { near: { type: 'Point', coordinates: ?1 }, distanceField: 'distance', spherical: true } }",
            "{ $match: { _id: { $not: { $eq: '?0' } } } }",
            "{ $sort : { distance : 1 } }",
            "{ $limit: 10 }",
            "{ $group: { _id: null, top_10_avg_distance: {$avg : '$distance' } } }",
            "{ $set: { _id: '?0' } }"        
    })
    List<AccidentWithDistanceSchema> allAvgDistanceBetweenTop10NearestAccidents(String id, Double[] point);
}
