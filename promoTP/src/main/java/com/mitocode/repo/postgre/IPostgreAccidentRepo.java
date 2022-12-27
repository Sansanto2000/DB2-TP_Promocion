package com.mitocode.repo.postgre;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.persistence.Accident;
import com.mitocode.model.schema.ConditionsSchema;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.sql.Date;
import java.util.List;

public interface IPostgreAccidentRepo extends JpaRepository<Accident, String>{

    @Query(value = "select * from accident a where a.start_Time BETWEEN ?1 AND ?2", nativeQuery = true)
    Slice<Accident> findByStartTimeBetween(Date startDate, Date endDate, Pageable pageable);

    @Query(value= "select avg(distance_mi) as average from accident", nativeQuery = true)
    Float averageDistanceOfAccidentsFromBeginningToEnd();
    
    @Query(value = "select a.street from accident a group by a.Street order by count(a.street) desc limit 5", nativeQuery = true)
    List<String> streetsWithMoreAccidents();

    //querys para mostCommonCondition

    @Query(value = "select tmc from accident where tmc is not null group by tmc order by count(tmc) desc limit 1", nativeQuery = true)
    Float mostCommonConditionTmc();

    @Query(value = "select severity from accident where severity is not null  group by severity order by count(severity) desc limit 1", nativeQuery = true)
    Integer mostCommonConditionSeverity();

    @Query(value = "select extract(hour from start_time) AS hour from accident where start_time is not null group by hour order by count(extract(hour from start_time)) desc limit 1", nativeQuery = true)
    String mostCommonConditionStartTime();

    @Query(value = "select extract(hour from end_time) from accident where end_time is not null group by extract(hour from end_time) order by count(extract(hour from end_time)) desc limit 1", nativeQuery = true)
    String mostCommonConditionEndTime();

    @Query(value = "select start_lat from accident where start_lat is not null group by start_lat order by count(start_lat) desc limit 1", nativeQuery = true)
    Float mostCommonConditionStartLat();

    @Query(value = "select start_lng from accident where start_lng is not null group by start_lng order by count(start_lng) desc limit 1", nativeQuery = true)
    Float mostCommonConditionStartLng();

    @Query(value = "select end_lat from accident where end_lat is not null group by end_lat order by count(end_lat) desc limit 1", nativeQuery = true)
    Float mostCommonConditionEndLat();

    @Query(value = "select end_lng from accident where end_lng is not null group by end_lng order by count(end_lng) desc limit 1", nativeQuery = true)
    Float mostCommonConditionEndLng();

    @Query(value = "select distance_mi from accident where distance_mi is not null group by distance_mi order by count(distance_mi) desc limit 1", nativeQuery = true)
    Float mostCommonConditionDistanceMi();

    @Query(value = "select number from accident where number is not null group by number order by count(number) desc limit 1", nativeQuery = true)
    Float mostCommonConditionNumber();

    @Query(value = "select street from accident where street is not null group by street order by count(street) desc limit 1", nativeQuery = true)
    String mostCommonConditionStreet();

    @Query(value = "select side from accident where side is not null group by side order by count(side) desc limit 1", nativeQuery = true)
    char mostCommonConditionSide();

    @Query(value = "select city from accident where city is not null group by city order by count(city) desc limit 1", nativeQuery = true)
    String mostCommonConditionCity();

    @Query(value = "select county from accident where county is not null group by county order by count(county) desc limit 1", nativeQuery = true)
    String mostCommonConditionCounty();

    @Query(value = "select state from accident where state is not null group by state order by count(state) desc limit 1", nativeQuery = true)
    String mostCommonConditionState();

    @Query(value = "select zipcode from accident where zipcode is not null group by zipcode order by count(zipcode) desc limit 1", nativeQuery = true)
    String mostCommonConditionZipcode();

    @Query(value = "select country from accident where country is not null group by country order by count(country) desc limit 1", nativeQuery = true)
    String mostCommonConditionCountry();
    @Query(value = "select timezone from accident where timezone is not null group by timezone order by count(timezone) desc limit 1", nativeQuery = true)
    String mostCommonConditionTimezone();
    @Query(value = "select airport_code from accident where airport_code is not null group by airport_code order by count(airport_code) desc limit 1", nativeQuery = true)
    String mostCommonConditionAirportCode();
    @Query(value = "select weather_timestamp from accident where weather_timestamp is not null group by weather_timestamp order by count(weather_timestamp) desc limit 1", nativeQuery = true)
    String mostCommonConditionWeatherTimestamp();

    @Query(value = "select temperature_f from accident where temperature_f is not null group by temperature_f order by count(temperature_f) desc limit 1", nativeQuery = true)
    Float mostCommonConditionTemperatureF();

    @Query(value = "select wind_chill_f from accident where wind_chill_f is not null group by wind_chill_f order by count(wind_chill_f) desc limit 1", nativeQuery = true)
    String mostCommonConditionWindChillF();

    @Query(value = "select humidity from accident where humidity is not null group by humidity order by count(humidity) desc limit 1", nativeQuery = true)
    String mostCommonConditionHumidity();

    @Query(value = "select pressure_in from accident where pressure_in is not null group by pressure_in order by count(pressure_in) desc limit 1", nativeQuery = true)
    String mostCommonConditionPressureIn();

    @Query(value = "select visibility_mi from accident where visibility_mi is not null group by visibility_mi order by count(visibility_mi) desc limit 1", nativeQuery = true)
    Float mostCommonConditionVisibilityMi();

    @Query(value = "select wind_direction from accident where wind_direction is not null group by wind_direction order by count(wind_direction) desc limit 1", nativeQuery = true)
    String mostCommonConditionWindDirection();

    @Query(value = "select wind_speed_mph from accident where wind_speed_mph is not null group by wind_speed_mph order by count(wind_speed_mph) desc limit 1", nativeQuery = true)
    Float mostCommonConditionWindSpeedMph();

    @Query(value = "select precipitation_in from accident where precipitation_in is not null group by precipitation_in order by count(precipitation_in) desc limit 1", nativeQuery = true)
    Float mostCommonConditionPrecipitation();

    @Query(value = "select weather_condition from accident where weather_condition is not null group by weather_condition order by count(weather_condition) desc limit 1", nativeQuery = true)
    String mostCommonConditionWeatherCondition();

    @Query(value = "select amenity from accident where amenity is not null group by amenity order by count(amenity) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionAmenity();

    @Query(value = "select bump from accident where bump is not null group by bump order by count(bump) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionBump();

    @Query(value = "select crossing from accident where crossing is not null group by crossing order by count(crossing) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionCrossing();

    @Query(value = "select give_way from accident where give_way is not null group by give_way order by count(give_way) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionGiveWay();

    @Query(value = "select junction from accident where junction is not null group by junction order by count(junction) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionJunction();

    @Query(value = "select no_exit from accident where no_exit is not null group by no_exit order by count(no_exit) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionNoExit();

    @Query(value = "select railway from accident where railway is not null group by railway order by count(railway) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionRailway();

    @Query(value = "select roundabout from accident where roundabout is not null group by roundabout order by count(roundabout) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionRoundabout();

    @Query(value = "select station from accident where station is not null group by station order by count(station) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionStation();

    @Query(value = "select stop from accident where stop is not null group by stop order by count(stop) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionStop();

    @Query(value = "select traffic_calming from accident where traffic_calming is not null group by traffic_calming order by count(traffic_calming) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionTrafficCalming();

    @Query(value = "select traffic_signal from accident where traffic_signal is not null group by traffic_signal order by count(traffic_signal) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionTrafficSignal();

    @Query(value = "select turning_loop from accident where turning_loop is not null group by turning_loop order by count(turning_loop) desc limit 1", nativeQuery = true)
    Boolean mostCommonConditionTurningLoop();

    @Query(value = "select sunrise_sunset from accident where sunrise_sunset is not null group by sunrise_sunset order by count(sunrise_sunset) desc limit 1", nativeQuery = true)
    String mostCommonConditionSunriseSunset();

    @Query(value = "select civil_twilight from accident where civil_twilight is not null group by civil_twilight order by count(civil_twilight) desc limit 1", nativeQuery = true)
    String mostCommonConditionCivilTwilight();

    @Query(value = "select nautical_twilight from accident where nautical_twilight is not null group by nautical_twilight order by count(nautical_twilight) desc limit 1", nativeQuery = true)
    String mostCommonConditionNuaticalTwilight();

    @Query(value = "select astronomical_twilight from accident where astronomical_twilight is not null group by astronomical_twilight order by count(astronomical_twilight) desc limit 1", nativeQuery = true)
    String mostCommonConditionAstronomicalTwilight();
}
