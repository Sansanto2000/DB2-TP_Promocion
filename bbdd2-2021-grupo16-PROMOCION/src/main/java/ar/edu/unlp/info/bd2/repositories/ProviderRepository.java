package ar.edu.unlp.info.bd2.repositories;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.model.Provider;

@Repository
public interface ProviderRepository extends ElasticsearchRepository<Provider, String> {

	Optional<Provider> findProviderByCuit(long cuit);
	Optional<Provider> findProviderByName(String name);
	
	/*
	 * //@
	 * Query("from Provider p where p not in (select pos.provider from Purchase p join p.productOnSale pos where p.dateOfPurchase = ?1)"
	 * ) List<Provider> findProvidersDoNotSellOn(Date day);
	 */

}
