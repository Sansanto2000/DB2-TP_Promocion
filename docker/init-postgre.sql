CREATE TABLE IF NOT EXISTS accident (
    id VARCHAR(256) NOT NULL,
    source VARCHAR ( 256 ),
    tmc FLOAT,
    severity SMALLINT ,
    start_time TIMESTAMP,
    end_time TIMESTAMP,
    start_lat DECIMAL (8,6),
    start_lng DECIMAL (9,6),
    end_lat DECIMAL (8,6),
    end_lng DECIMAL (9,6),
    distance_mi FLOAT,
    description TEXT,
    number FLOAT,
    street VARCHAR(256),
    side CHAR,
    city VARCHAR(256),
    county VARCHAR(256),
    state VARCHAR(256),
    zipcode VARCHAR(10),
    country VARCHAR(256),
    timezone VARCHAR(256),
    airport_code VARCHAR(256),
    weather_timestamp VARCHAR(256),
    temperature_f FLOAT,
    wind_chill_f VARCHAR(256),
    humidity VARCHAR(256),
    pressure_in VARCHAR(256),
    visibility_mi FLOAT,
    wind_direction VARCHAR(256),
    wind_speed_mph FLOAT,
    precipitation_in FLOAT,
    weather_condition VARCHAR(256),
    amenity BOOLEAN,
    bump BOOLEAN,
    crossing BOOLEAN,
    give_way BOOLEAN,
    junction BOOLEAN,
    no_exit BOOLEAN,
    railway BOOLEAN,
    roundabout BOOLEAN,
    station BOOLEAN,
    stop BOOLEAN,
    traffic_calming BOOLEAN,
    traffic_signal BOOLEAN,
    turning_loop BOOLEAN,
    sunrise_sunset VARCHAR(10),
    civil_twilight VARCHAR(10),
    nautical_twilight VARCHAR(10),
    astronomical_twilight VARCHAR(10)
);

create index I_start_time on accident(start_time);
create index I_end_time on accident(end_time);
create index I_distance_mi on accident(distance_mi);
create index I_street on accident(street);
create index I_temperature_f on accident(temperature_f);
create index I_wind_chill_f on accident(wind_chill_f);
create index I_humidity on accident(humidity);
create index I_pressure_in on accident(pressure_in);
create index I_visibility_mi on accident(visibility_mi);
create index I_wind_direction on accident(wind_direction);
create index I_wind_speed_mph on accident(wind_speed_mph);
create index I_precipitation_in on accident(precipitation_in);
create index I_weather_condition on accident(weather_condition);
create index I_amenity on accident(amenity);
create index I_bump on accident(bump);
create index I_crossing on accident(crossing);
create index I_give_way on accident(give_way);
create index I_junction on accident(junction);
create index I_no_exit on accident(no_exit);
create index I_railway on accident(railway);
create index I_roundabout on accident(roundabout);
create index I_station on accident(station);
create index I_stop on accident(stop);
create index I_traffic_calming on accident(traffic_calming);
create index I_traffic_signal on accident(traffic_signal);
create index I_turning_loop on accident(turning_loop);
create index I_sunrise_sunset on accident(sunrise_sunset);
create index I_civil_twilight on accident(civil_twilight);
create index I_nautical_twilight on accident(nautical_twilight);
create index I_astronomical_twilight on accident(astronomical_twilight);

COPY accident(id,source,tmc,severity,start_time,end_time,start_lat,start_lng,end_lat,end_lng,distance_mi,description,number,street,side,city,county,state,zipcode,country,timezone,airport_code,weather_timestamp,temperature_f,wind_chill_f,humidity,pressure_in,visibility_mi,wind_direction,wind_speed_mph,precipitation_in,weather_condition,amenity,bump,crossing,give_way,junction,no_exit,railway,roundabout,station,stop,traffic_calming,traffic_signal,turning_loop,sunrise_sunset,civil_twilight,nautical_twilight,astronomical_twilight)
FROM '/csv/US_Accidents_Dec19.csv'
DELIMITER ','
CSV HEADER;