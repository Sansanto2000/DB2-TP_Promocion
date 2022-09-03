package ar.edu.unlp.info.bd2.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.model.Purchase;

@Repository
public interface PurchaseRepository extends ElasticsearchRepository<Purchase, String>{

	List<Purchase> findAllByClientId(String user);

	List<Purchase> findByDateOfPurchase(Date day);

	// @Query("select p from Purchase p join p.productOnSale pos where pos.provider // = (select id from Provider where cuit = ?1)")
	List<Purchase> findByProductOnSaleProviderCuit(Long cuit);
	// @Query("select pos.product from Purchase pur join pur.productOnSale pos join pos.product p group by p order by count(pur) desc")
	@Query(" { \"size\" : 10, \"_source\" : false, \"fields\" : [ { \"field\" : \"productOnSale.product._class\" } ], \"sort\" : [ { \"_doc\" : { \"order\" : \"asc\" } } ] }")
	Page<Purchase> findBestSellingProduct(Pageable pageable);
	
	//No funciona porque el gasto total de la compra sale de una multiplicacion de pos.price*quantity
	// @Query("select p.client from Purchase p join p.productOnSale pos where (p.quantity * pos.price) > ?1")
	List<Purchase> findByTotalGreaterThan(Float amount);
	
	// @Query("from Purchase p where p.dateOfPurchase >= ?1 and p.dateOfPurchase <= ?2")
	List<Purchase> findByDateOfPurchaseBetween(Date startDate, Date endDate);
	
	/*
	 * // @Query("select p.client from Purchase p join p.productOnSale pos group by
	 * // p.client having sum(p.quantity * pos.price) > ?1") List<User>
	 * findUsersSpendingMoreThan(double amount);
	 * 
	 * // @Query("select d from Purchase p join p.deliveryMethod d group by d order
	 * by // count(d) desc") Page<DeliveryMethod>
	 * findMostUsedDeliveryMethod(Pageable pageable);
	 * 
	 * // @Query("select p.paymentMethod from Purchase p join p.paymentMethod pay
	 * join // p.productOnSale pos join p.deliveryMethod d where
	 * p.paymentMethod.class = 2 // order by ((p.quantity * pos.price + d.cost) -
	 * pay.promisedAmount)") Page<OnDeliveryPayment>
	 * findMoreChangeOnDeliveryMethod(Pageable pageable);
	 */

}
