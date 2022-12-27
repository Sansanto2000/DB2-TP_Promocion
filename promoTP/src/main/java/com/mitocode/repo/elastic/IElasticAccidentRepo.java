package com.mitocode.repo.elastic;

import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.mitocode.model.persistence.Accident;

import org.springframework.data.elasticsearch.annotations.Query;
//import org.springframework.data.elasticsearch.repository.query.Query;
//import org.springframework.data.elasticsearch.repository.Query;

import java.util.List;

public interface IElasticAccidentRepo extends ElasticsearchRepository<Accident, String> {

    //Page<Book> findByAuthor(String author, Pageable pageable);

    @Query("{ \"match_all\": {} }")
    Page<Accident> test(Pageable pageable);

    Page<Accident> findByCountry(String country, Pageable pageable);

}