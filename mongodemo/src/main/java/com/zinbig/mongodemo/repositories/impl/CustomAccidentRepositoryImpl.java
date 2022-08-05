/**
 * Este paquete contiene las implementaciones de los repositorios personalizados.
 */
package com.zinbig.mongodemo.repositories.impl;

import com.zinbig.mongodemo.repositories.CustomAccidentRepository;

/**
 * Esta clase implementa los mecanismos personalizados de recuperación de
 * información.
 *
 * @author Javier Bazzocco
 *
 */
public class CustomAccidentRepositoryImpl implements CustomAccidentRepository {

    // private MongoTemplate mongoTemplate;

    /**
     * Obtiene la cantidad de usuarios que tienen el mismo "Source".
     *
     * @return el número de usuarios.
     */
    @Override
    public int getNumberOfAccidentsThatHasTheSameSource() {
        return 4;

//		Update update = new Update();
//		update.set("rLiqFilterClassName", aFilterClassName);
//		update.set("employees", someEmployees);
//		update.set("dateFrom", aDateFrom);
//		update.set("dateTo", aDateTo);
//		update.set("status", aStatus);
//		mongoTemplate.updateFirst(Query.query(Criteria.where("rLiqFilterClassName").is(oldFilterClassName)), update,
//				FilterConfiguration.class);
/////////////////////////////////////////////////////////////////////
//		Collection<String> result = new ArrayList<String>();
//		DistinctIterable<String> distinctIterable = mongoTemplate.getCollection("receipt").distinct("ulic",
//				String.class);
//		MongoCursor<String> cursor = distinctIterable.iterator();
//		while (cursor.hasNext()) {
//			result.add(cursor.next().toString());
//		}
//
//		return result.size();
//////////////////////////////////////////////////////////////////////
//		GroupOperation sum = Aggregation.group("period").count().as("count");
//		SortOperation sortByCount = Aggregation.sort(Direction.ASC, "period");
//
//		Aggregation aggregation = Aggregation.newAggregation(sum, sortByCount);
//
//		AggregationResults<ResultCount> result = mongoTemplate.aggregate(aggregation, "liquidation",
//				ResultCount.class);
//		return result.getMappedResults();
    }

}
