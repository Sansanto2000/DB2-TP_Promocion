package com.mitocode.repo.postgre;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Accident;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import java.util.List;

public interface IPostgreAccidentRepo extends JpaRepository<Accident, String>{
    @Query(value = "select * from accident a where (a.start_Time BETWEEN ?1 AND ?2)", nativeQuery = true)
    List<Accident> accidentsBetweenTwoDates(Date startDate, Date endDate);
}
