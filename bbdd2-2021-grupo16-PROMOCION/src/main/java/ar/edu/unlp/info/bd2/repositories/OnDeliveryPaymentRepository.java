package ar.edu.unlp.info.bd2.repositories;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.model.OnDeliveryPayment;

@Repository
public interface OnDeliveryPaymentRepository extends ElasticsearchRepository<OnDeliveryPayment, String> {
	Optional<OnDeliveryPayment> findOnDeliveryPaymentByName(String name);
}
