package com.mitocode.repo.postgre;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Accident;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.sql.Date;
import java.util.List;

public interface IPostgreAccidentRepo extends JpaRepository<Accident, String>{

    @Query(value = "select * from accident a where a.start_Time BETWEEN ?1 AND ?2", nativeQuery = true)
    Slice<Accident> findByStartTimeBetween(Date startDate, Date endDate, Pageable pageable);

    //@Query(value = "select street, count(street) as total from accidents group by street order by total desc limit 5", nativeQuery = true)
    @Query(value = "select a.street from accident a group by a.Street order by count(a.street) desc", nativeQuery = true)
    List<String> streetsWithMoreAccidents();

    @Query(value= "select avg(distance_mi) as average from accident", nativeQuery = true)
    Float averageDistanceOfAccidentsFromBeginningToEnd();

    //@Query(value = "select distance_mi from accidents where distance_mi is not null group by distance_mi order by count(distance_mi) desc limit 1", nativeQuery = true)
    @Query(value = "select ?1 from accident where ?1 is not null group by ?1 order by count(?1) desc limit 1", nativeQuery = true)
    String mostCommonCondition(String condition);

    @Query(value = "select ?1 from accident where ?1 is not null group by ?1 order by count(?1) desc limit 1", nativeQuery = true)
    Date mostCommonConditionDate(String condition);

    @Query(value = "select distance_mi from accident where distance_mi is not null group by distance_mi order by count(distance_mi) desc limit 1", nativeQuery = true)
    Float mostCommonConditionDistanceMi();

    @Query(value = "select number from accident where number is not null group by number order by count(number) desc limit 1", nativeQuery = true)
    Float mostCommonConditionNumber();

    @Query(value = "select temperature_f from accident where temperature_f is not null group by temperature_f order by count(temperature_f) desc limit 1", nativeQuery = true)
    Float mostCommonConditionTemperatureF();

    @Query(value = "select visibility_mi from accident where visibility_mi is not null group by visibility_mi order by count(visibility_mi) desc limit 1", nativeQuery = true)
    Float mostCommonConditionVisibilityMi();

    @Query(value = "select wind_speed_mph from accident where wind_speed_mph is not null group by wind_speed_mph order by count(wind_speed_mph) desc limit 1", nativeQuery = true)
    Float mostCommonConditionWindSpeedMph();

    @Query(value = "select precipitation_in from accident where precipitation_in is not null group by precipitation_in order by count(precipitation_in) desc limit 1", nativeQuery = true)
    Float mostCommonConditionPrecipitation();
}
