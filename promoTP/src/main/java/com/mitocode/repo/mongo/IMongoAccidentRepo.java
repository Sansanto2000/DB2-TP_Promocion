package com.mitocode.repo.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;
import com.mitocode.model.LocationAndAmount;
import com.mitocode.model.Accident;
import com.mitocode.model.AccidentWithDistance;

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
	
	// Esta consulta nos funciona en consola pero no conseguimos que retorne valor
    // valido para 'distancia' a traves de la API.
    // La causa es seguramente que como se esta usando el .map, se esta devolviendo
    // un arreglo y no un cursor como en las otras consultas.
    @Query("{}.map(function(doc){" +
                "return db.accident.aggregate([{" +
                    "$geoNear: {" +
                        "near: {" +
                            "type: 'Point', coordinates: [doc.Start_Lng, doc.Start_Lat]" +
                        "}, " +
                        "distanceField: 'distance', " +
                        "spherical: true" +
                    "}, " +
                    "{$limit:10}, " +
                    "{$group: {_id:null, distance:{$avg:'$distance'}}}" +
                "}," +
                "{$set: {_id: doc._id}}]).toArray()[0];" +
            "})")
    List<AccidentWithDistance> avgDistanceBetweenTop10NearestAccidents();
}
