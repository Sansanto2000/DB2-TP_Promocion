package ar.edu.unlp.info.bd2.repositories;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.model.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

	Optional<User> findUserByEmail(String email);

	/*
	 * //@
	 * Query("select c from Purchase p join p.client c group by c order by count(p) desc"
	 * ) Page<User> findTopNUsersMorePurchase(int n, Pageable pageable);
	 */

}
