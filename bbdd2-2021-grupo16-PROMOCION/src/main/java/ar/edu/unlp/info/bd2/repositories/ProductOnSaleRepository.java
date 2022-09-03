package ar.edu.unlp.info.bd2.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.model.Product;
import ar.edu.unlp.info.bd2.model.ProductOnSale;

@Repository
public interface ProductOnSaleRepository extends ElasticsearchRepository<ProductOnSale, String> {

	Optional<ProductOnSale> findByProductIdAndProviderIdAndActual(String productId, String providerId, Boolean actual);

	Optional<ProductOnSale> findProductOnSalesById(String id);

	Page<ProductOnSale> findByActualFalseOrderByPrice(Pageable pageable);
	
	//@Query("{ \"query\": { \"filtered\" : { \"filter\" : { \"limit\" : {\"value\" : 10} }, \"sort\" : [ {\"price\" : {\"order\" : \"desc\"}} ] \"query\" : { \"match_all\": {} } } }}")
	//Page<Product> findTop3MoreExpensiveProducts(Pageable pageable);
	/**
	 * //@ Query("select pro from Purchase p join p.productOnSale pos join
	 * pos.provider pro group by pro order by count(*) desc" ) Page<Provider>
	 * findTopNProvidersInPurchases(int n, Pageable pageable);
	 */

}
