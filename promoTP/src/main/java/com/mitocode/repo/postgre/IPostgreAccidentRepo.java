package com.mitocode.repo.postgre;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Accident;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.Date;
import java.util.List;

public interface IPostgreAccidentRepo extends JpaRepository<Accident, String>{
    @Query(value = "select * from accident a where (a.start_Time BETWEEN ?1 AND ?2)", nativeQuery = true)
    Slice<Accident> accidentsBetweenTwoDates(Date startDate, Date endDate, Pageable pageable);

    //@Query(value = "select street, count(street) as total from accidents group by street order by total desc limit 5", nativeQuery = true)
    @Query(value = "select a.street from accident a group by a.Street order by count(a.street) desc", nativeQuery = true)
    List<String> streetsWithMoreAccidents();

    @Query(value= "select avg(distance_mi) as average from accident", nativeQuery = true)
    Float averageDistanceOfAccidentsFromBeginningToEnd();

    @Query(value = "select ?1 from accidents where ?1 is not null  group by ?1 order by count(?1) desc limit 1", nativeQuery = true)
    String mostCommonCondition(string condition);
}
