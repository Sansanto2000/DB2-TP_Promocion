CREATE TABLE IF NOT EXISTS accident (
    "ID" text,
    "Source" text,
    "TMC" float8 DEFAULT NULL,
    "Severity" int DEFAULT NULL,
    "Start_Time" timestamp DEFAULT NULL,
    "End_Time" timestamp DEFAULT NULL,
    "Start_Lat" float8 DEFAULT NULL,
    "Start_Lng" float8 DEFAULT NULL,
    "End_Lat" text,
    "End_Lng" text,
    "Distance(mi)" float8 DEFAULT NULL,
    "Description" text,
    "Number" text,
    "Street" text,
    "Side" text,
    "City" text,
    "County" text,
    "State" text,
    "Zipcode" text,
    "Country" text,
    "Timezone" text,
    "Airport_Code" text,
    "Weather_Timestamp" text,
    "Temperature(F)" float8 DEFAULT NULL,
    "Wind_Chill(F)" text,
    "Humidity(%)" float8 DEFAULT NULL,
    "Pressure(in)" float8 DEFAULT NULL,
    "Visibility(mi)" float8 DEFAULT NULL,
    "Wind_Direction" text,
    "Wind_Speed(mph)" text,
    "Precipitation(in)" text,
    "Weather_Condition" text,
    "Amenity" text,
    "Bump" text,
    "Crossing" text,
    "Give_Way" text,
    "Junction" text,
    "No_Exit" text,
    "Railway" text,
    "Roundabout" text,
    "Station" text,
    "Stop" text,
    "Traffic_Calming" text,
    "Traffic_Signal" text,
    "Turning_Loop" text,
    "Sunrise_Sunset" text,
    "Civil_Twilight" text,
    "Nautical_Twilight" text,
    "Astronomical_Twilight" text
);

COPY accident("ID", "Source", "TMC", "Severity", "Start_Time", "End_Time", "Start_Lat", "Start_Lng", "End_Lat", "End_Lng", "Distance(mi)", "Description", "Number", "Street", "Side", "City", "County", "State", "Zipcode", "Country", "Timezone", "Airport_Code", "Weather_Timestamp", "Temperature(F)", "Wind_Chill(F)", "Humidity(%)", "Pressure(in)", "Visibility(mi)", "Wind_Direction", "Wind_Speed(mph)", "Precipitation(in)", "Weather_Condition", "Amenity", "Bump", "Crossing", "Give_Way", "Junction", "No_Exit", "Railway", "Roundabout", "Station", "Stop", "Traffic_Calming", "Traffic_Signal", "Turning_Loop", "Sunrise_Sunset", "Civil_Twilight", "Nautical_Twilight", "Astronomical_Twilight")
FROM '/csv/US_Accidents_Dec19.csv'
DELIMITER ','
CSV HEADER;