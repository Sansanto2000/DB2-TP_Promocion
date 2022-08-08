package com.zinbig.mongodemo.repositories.JpaRepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zinbig.mongodemo.model.Accident;

import org.springframework.data.domain.Pageable;

@Repository
public interface AccidentRepositoryPostgres extends CrudRepository<Accident, String> {

    @Query(value = "select * from accidents where start_time between ?1 and ?2", nativeQuery = true)
    List<Accident> findByStartTimeBetween(Date beginDate, Date endDate, Pageable pageable);

    // List<Accident> accidentsNearAPointInARadius( String point, int radius);

    @Query(value = "SELECT avg(distance_mi) AS average FROM accidents", nativeQuery = true)
    Float averageDistanceMi();

    // List<Accident> fiveMostDangerousPoints();

    // List<Integer> averageDistanceFromEveryAccidentToTheNearestTen();

    @Query(value = "select street, count(street) as total from accidents group by street order by total desc limit 5", nativeQuery = true)
    List<String> findByStreetsWithMoreAccidents();

    @Query(value = "select tmc from accidents where tmc is not null group by tmc order by count(tmc) desc limit 1", nativeQuery = true)
    Float mostCommonConditionTmc();

    @Query(value = "select severity from accidents where severity is not null  group by severity order by count(severity) desc limit 1", nativeQuery = true)
    Integer mostCommonConditionSeverity();

    @Query(value = "select extract(hour from start_time) AS hour from accidents where start_time is not null group by hour order by count(extract(hour from start_time)) desc limit 1", nativeQuery = true)
    String mostCommonConditionStartTime();

    @Query(value = "select extract(hour from end_time) from accidents where end_time is not null group by extract(hour from end_time) order by count(extract(hour from end_time)) desc limit 1", nativeQuery = true)
    String mostCommonConditionEndTime();

    @Query(value = "select distance_mi from accidents where distance_mi is not null group by distance_mi order by count(distance_mi) desc limit 1", nativeQuery = true)
    Float mostCommonConditionDistanceMi();

    @Query(value = "select number from accidents where number is not null group by number order by count(number) desc limit 1", nativeQuery = true)
    Float mostCommonConditionNumber();

    @Query(value = "select street from accidents where street is not null group by street order by count(street) desc limit 1", nativeQuery = true)
    String mostCommonConditionStreet();

    @Query(value = "select side from accidents where side is not null group by side order by count(side) desc limit 1", nativeQuery = true)
    char mostCommonConditionSide();

    @Query(value = "select city from accidents where city is not null group by city order by count(city) desc limit 1", nativeQuery = true)
    String mostCommonConditionCity();

    @Query(value = "select county from accidents where county is not null group by county order by count(county) desc limit 1", nativeQuery = true)
    String mostCommonConditionCounty();

    @Query(value = "select state from accidents where state is not null group by state order by count(state) desc limit 1", nativeQuery = true)
    String mostCommonConditionState();

    @Query(value = "select zipcode from accidents where zipcode is not null group by zipcode order by count(zipcode) desc limit 1", nativeQuery = true)
    String mostCommonConditionZipcode();

    @Query(value = "select temperature_f from accidents where temperature_f is not null group by temperature_f order by count(temperature_f) desc limit 1", nativeQuery = true)
    Float mostCommonConditionTemperatureF();

    @Query(value = "select wind_chill_f from accidents where wind_chill_f is not null group by wind_chill_f order by count(wind_chill_f) desc limit 1", nativeQuery = true)
    String mostCommonConditionWindChillF();

    @Query(value = "select humidity from accidents where humidity is not null group by humidity order by count(humidity) desc limit 1", nativeQuery = true)
    String mostCommonConditionHumidity();

    @Query(value = "select pressure_in from accidents where pressure_in is not null group by pressure_in order by count(pressure_in) desc limit 1", nativeQuery = true)
    String mostCommonConditionPressureIn();

    @Query(value = "select visibility_mi from accidents where visibility_mi is not null group by visibility_mi order by count(visibility_mi) desc limit 1", nativeQuery = true)
    Float mostCommonConditionVisibilityMi();

    @Query(value = "select wind_direction from accidents where wind_direction is not null group by wind_direction order by count(wind_direction) desc limit 1", nativeQuery = true)
    String mostCommonConditionWindDirection();

    @Query(value = "select wind_speed_mph from accidents where wind_speed_mph is not null group by wind_speed_mph order by count(wind_speed_mph) desc limit 1", nativeQuery = true)
    Float mostCommonConditionWindSpeedMph();

    @Query(value = "select precipitation_in from accidents where precipitation_in is not null group by precipitation_in order by count(precipitation_in) desc limit 1", nativeQuery = true)
    Float mostCommonConditionPrecipitation();

    @Query(value = "select weather_condition from accidents where weather_condition is not null group by weather_condition order by count(weather_condition) desc limit 1", nativeQuery = true)
    String mostCommonConditionWeatherCondition();

    @Query(value = "select amenity from accidents where amenity is not null group by amenity order by count(amenity) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionAmenity();

    @Query(value = "select bump from accidents where bump is not null group by bump order by count(bump) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionBump();

    @Query(value = "select crossing from accidents where crossing is not null group by crossing order by count(crossing) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionCrossing();

    @Query(value = "select give_way from accidents where give_way is not null group by give_way order by count(give_way) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionGiveWay();

    @Query(value = "select junction from accidents where junction is not null group by junction order by count(junction) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionJunction();

    @Query(value = "select no_exit from accidents where no_exit is not null group by no_exit order by count(no_exit) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionNoExit();

    @Query(value = "select railway from accidents where railway is not null group by railway order by count(railway) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionRailway();

    @Query(value = "select roundabout from accidents where roundabout is not null group by roundabout order by count(roundabout) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionRoundabout();

    @Query(value = "select station from accidents where station is not null group by station order by count(station) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionStation();

    @Query(value = "select stop from accidents where stop is not null group by stop order by count(stop) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionStop();

    @Query(value = "select traffic_calming from accidents where traffic_calming is not null group by traffic_calming order by count(traffic_calming) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionTrafficCalming();

    @Query(value = "select traffic_signal from accidents where traffic_signal is not null group by traffic_signal order by count(traffic_signal) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionTrafficSignal();

    @Query(value = "select turning_loop from accidents where turning_loop is not null group by turning_loop order by count(turning_loop) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionTurningLoop();

    @Query(value = "select sunrise_sunset from accidents where sunrise_sunset is not null group by sunrise_sunset order by count(sunrise_sunset) desc limit 1", nativeQuery = true)
    String mostCommonConditionSunriseSunset();

    @Query(value = "select civil_twilight from accidents where civil_twilight is not null group by civil_twilight order by count(civil_twilight) desc limit 1", nativeQuery = true)
    String mostCommonConditionCivilTwilight();

    @Query(value = "select nautical_twilight from accidents where nautical_twilight is not null group by nautical_twilight order by count(nautical_twilight) desc limit 1", nativeQuery = true)
    String mostCommonConditionNuaticalTwilight();

    @Query(value = "select astronomical_twilight from accidents where astronomical_twilight is not null group by astronomical_twilight order by count(astronomical_twilight) desc limit 1", nativeQuery = true)
    String mostCommonConditionAstronomicalTwilight();
}
