package ar.edu.unlp.info.bd2.repositories;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.model.DeliveryMethod;

@Repository
public interface DeliveryMethodRepository extends ElasticsearchRepository<DeliveryMethod, String> {

	Optional<DeliveryMethod> findByName(String name);

}
