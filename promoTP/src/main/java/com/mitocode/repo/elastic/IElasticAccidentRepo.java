package com.mitocode.repo.elastic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.mitocode.model.Accident;

import java.util.List;

public interface IElasticAccidentRepo extends ElasticsearchRepository<Accident, String> {

    //Page<Book> findByAuthor(String author, Pageable pageable);

    Page<Accident> findByCountry(String country, Pageable pageable);

}