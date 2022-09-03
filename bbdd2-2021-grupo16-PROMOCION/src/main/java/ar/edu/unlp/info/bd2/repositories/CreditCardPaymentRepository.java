package ar.edu.unlp.info.bd2.repositories;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.model.CreditCardPayment;

@Repository
public interface CreditCardPaymentRepository extends ElasticsearchRepository<CreditCardPayment, String> {

	Optional<CreditCardPayment> findCreditCardPaymentByName(String name);

}
