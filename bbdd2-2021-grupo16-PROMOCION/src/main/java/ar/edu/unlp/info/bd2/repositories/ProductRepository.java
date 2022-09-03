package ar.edu.unlp.info.bd2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.model.Product;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {

	@Query("{\"match_phrase\": {\"name\": \"?0\"}}")
	Optional<Product> findProductByName(String name);

	List<Product> findAllByCategoryId(String category);
	
	//@Query("from Product p where p.weight = (select max(p.weight) from Product p)")
	Page<Product> findFirstByOrderByWeightDesc(Pageable pageable);
		 
	/*
	 * // @Query("select p from Product p join p.productOnSales c group by p having
	 * // count(c) = 1") List<Product> findProductsOnePrice();
	 * 
	 * @Query("select distinct pos1.product from ProductOnSale pos1, ProductOnSale pos2 "
	 * + "where pos1.product = pos2.product " +
	 * " and pos1.provider != pos2.provider " +
	 * " and ((pos1.price * 1.2) < pos2.price)")
	 * 
	 * List<Product> findProductWithMoreThan20percentDiferenceInPrice();
	 * 
	 * // @Query("select p from Product p where p not in (select distinct //
	 * pur.productOnSale.product from Purchase pur)") List<Product>
	 * findProductsNotSold();
	 
	 * // @Query("select c from Product p join p.category c group by c order by //
	 * count(c) asc") Page<Category> findCategoryWithLessProducts(Pageable
	 * pageable);
	 */
}
