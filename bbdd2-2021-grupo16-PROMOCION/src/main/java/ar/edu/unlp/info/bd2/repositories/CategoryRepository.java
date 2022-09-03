package ar.edu.unlp.info.bd2.repositories;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unlp.info.bd2.model.Category;

@Repository
public interface CategoryRepository extends ElasticsearchRepository<Category, String> {
	Optional<Category> findCategoryByName(String categoryName);
}
