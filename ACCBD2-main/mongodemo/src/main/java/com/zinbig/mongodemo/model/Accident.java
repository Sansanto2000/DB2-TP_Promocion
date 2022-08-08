/** Este paquete contiene las clases que representan las entidades del dominio. */
package com.zinbig.mongodemo.model;

import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accidents")
public class Accident {

    @Id
    private String id;
    @Field("Source")
    private String source;
    @Field("TMC")
    private Float tmc;
    @Field("Severity")
    private Integer severity;
    @Field("Start_Time")
    private String startTime;
    @Field("End_Time")
    private String endTime;
    @Field("Start_Lat")
    private Float startLat;
    @Field("Start_Lng")
    private Float startLng;
    @Field("End_Lat")
    private Float endLat;
    @Field("End_Lng")
    private Float endLng;
    @Field("Distance(mi)")
    private Float distanceMi;
    @Field("Description")
    private String description;
    @Field("Number")
    private Float number;
    @Field("Street")
    private String street;
    @Field("Side")
    private char side;
    @Field("City")
    private String city;
    @Field("County")
    private String county;
    @Field("State")
    private String state;
    @Field("Zipcode")
    private String zipcode;
    @Field("Country")
    private String country;
    @Field("Timezone")
    private String timezone;
    @Field("Airport_Code")
    private String airportCode;
    @Field("Weather_Timestamp")
    private String weatherTimestamp;
    @Field("Temperature(F)")
    @Column(name = "temperature_f")
    private Float temperatureF;
    @Field("Wind_Chill(F)")
    @Column(name = "wind_chill_f")
    private String windChillF;
    @Field("Humidity(%)")
    private String humidity;
    @Field("Pressure(in)")
    private String pressureIn;
    @Field("Visibility(mi)")
    private Float visibilityMi;
    @Field("Wind_Direction")
    private String windDirection;
    @Field("Wind_Speed(mph)")
    private Float windSpeedMph;
    @Field("Precipitation(in)")
    private Float precipitationIn;
    @Field("Weather_Condition")
    private String weatherCondition;
    @Field("Amenity")
    private Boolean amenity;
    @Field("Bump")
    private Boolean bump;
    @Field("Crossing")
    private Boolean crossing;
    @Field("Give_Way")
    private Boolean giveWay;
    @Field("Junction")
    private Boolean junction;
    @Field("No_Exit")
    private Boolean noExit;
    @Field("Railway")
    private Boolean railway;
    @Field("Roundabout")
    private Boolean roundabout;
    @Field("Station")
    private Boolean station;
    @Field("Stop")
    private Boolean stop;
    @Field("Traffic_Calming")
    private Boolean trafficCalming;
    @Field("Traffic_Signal")
    private Boolean trafficSignal;
    @Field("Turning_Loop")
    private Boolean turningLoop;
    @Field("Sunrise_Sunset")
    private String sunriseSunset;
    @Field("Civil_Twilight")
    private String civilTwilight;
    @Field("Nautical_Twilight")
    private String nauticalTwilight;
    @Field("Astronomical_Twilight")
    private String astronomicalTwilight;

    public Accident() {
    }

    public Accident(String id, String source, Float tmc, Integer severity, String startTime, String endTime,
            Float startLat, Float startLng, Float endLat, Float endLng, Float distanceMi, String description,
            Float number, String street, char side, String city, String county, String state, String zipcode,
            String country, String timezone, String airportCode, String weatherTimestamp, Float temperatureF,
            String windChillF, String humidity, String pressureIn, Float visibilityMi, String windDirection,
            Float windSpeedMph, Float precipitationIn, String weatherCondition, Boolean amenity, Boolean bump,
            Boolean crossing, Boolean giveWay, Boolean junction, Boolean noExit, Boolean railway, Boolean roundabout,
            Boolean station, Boolean stop, Boolean trafficCalming, Boolean trafficSignal, Boolean turningLoop,
            String sunriseSunset, String civilTwilight, String nauticalTwilight, String astronomicalTwilight,
            String location) {
        this.id = id;
        this.source = source;
        this.tmc = tmc;
        this.severity = severity;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startLat = startLat;
        this.startLng = startLng;
        this.endLat = endLat;
        this.endLng = endLng;
        this.distanceMi = distanceMi;
        this.description = description;
        this.number = number;
        this.street = street;
        this.side = side;
        this.city = city;
        this.county = county;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
        this.timezone = timezone;
        this.airportCode = airportCode;
        this.weatherTimestamp = weatherTimestamp;
        this.temperatureF = temperatureF;
        this.windChillF = windChillF;
        this.humidity = humidity;
        this.pressureIn = pressureIn;
        this.visibilityMi = visibilityMi;
        this.windDirection = windDirection;
        this.windSpeedMph = windSpeedMph;
        this.precipitationIn = precipitationIn;
        this.weatherCondition = weatherCondition;
        this.amenity = amenity;
        this.bump = bump;
        this.crossing = crossing;
        this.giveWay = giveWay;
        this.junction = junction;
        this.noExit = noExit;
        this.railway = railway;
        this.roundabout = roundabout;
        this.station = station;
        this.stop = stop;
        this.trafficCalming = trafficCalming;
        this.trafficSignal = trafficSignal;
        this.turningLoop = turningLoop;
        this.sunriseSunset = sunriseSunset;
        this.civilTwilight = civilTwilight;
        this.nauticalTwilight = nauticalTwilight;
        this.astronomicalTwilight = astronomicalTwilight;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Float getTmc() {
        return this.tmc;
    }

    public void setTmc(Float tmc) {
        this.tmc = tmc;
    }

    public Integer getSeverity() {
        return this.severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Float getStartLat() {
        return this.startLat;
    }

    public void setStartLat(Float startLat) {
        this.startLat = startLat;
    }

    public Float getStartLng() {
        return this.startLng;
    }

    public void setStartLng(Float startLng) {
        this.startLng = startLng;
    }

    public Float getEndLat() {
        return this.endLat;
    }

    public void setEndLat(Float endLat) {
        this.endLat = endLat;
    }

    public Float getEndLng() {
        return this.endLng;
    }

    public void setEndLng(Float endLng) {
        this.endLng = endLng;
    }

    public Float getDistanceMi() {
        return this.distanceMi;
    }

    public void setDistanceMi(Float distanceMi) {
        this.distanceMi = distanceMi;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getNumber() {
        return this.number;
    }

    public void setNumber(Float number) {
        this.number = number;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public char getSide() {
        return this.side;
    }

    public void setSide(char side) {
        this.side = side;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return this.county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getAirportCode() {
        return this.airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getWeatherTimestamp() {
        return this.weatherTimestamp;
    }

    public void setWeatherTimestamp(String weatherTimestamp) {
        this.weatherTimestamp = weatherTimestamp;
    }

    public Float getTemperatureF() {
        return this.temperatureF;
    }

    public void setTemperatureF(Float temperatureF) {
        this.temperatureF = temperatureF;
    }

    public String getWindChillF() {
        return this.windChillF;
    }

    public void setWindChillF(String windChillF) {
        this.windChillF = windChillF;
    }

    public String getHumidity() {
        return this.humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressureIn() {
        return this.pressureIn;
    }

    public void setPressureIn(String pressureIn) {
        this.pressureIn = pressureIn;
    }

    public Float getVisibilityMi() {
        return this.visibilityMi;
    }

    public void setVisibilityMi(Float visibilityMi) {
        this.visibilityMi = visibilityMi;
    }

    public String getWindDirection() {
        return this.windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public Float getWindSpeedMph() {
        return this.windSpeedMph;
    }

    public void setWindSpeedMph(Float windSpeedMph) {
        this.windSpeedMph = windSpeedMph;
    }

    public Float getPrecipitationIn() {
        return this.precipitationIn;
    }

    public void setPrecipitationIn(Float precipitationIn) {
        this.precipitationIn = precipitationIn;
    }

    public String getWeatherCondition() {
        return this.weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public Boolean isAmenity() {
        return this.amenity;
    }

    public Boolean getAmenity() {
        return this.amenity;
    }

    public void setAmenity(Boolean amenity) {
        this.amenity = amenity;
    }

    public Boolean isBump() {
        return this.bump;
    }

    public Boolean getBump() {
        return this.bump;
    }

    public void setBump(Boolean bump) {
        this.bump = bump;
    }

    public Boolean isCrossing() {
        return this.crossing;
    }

    public Boolean getCrossing() {
        return this.crossing;
    }

    public void setCrossing(Boolean crossing) {
        this.crossing = crossing;
    }

    public Boolean isGiveWay() {
        return this.giveWay;
    }

    public Boolean getGiveWay() {
        return this.giveWay;
    }

    public void setGiveWay(Boolean giveWay) {
        this.giveWay = giveWay;
    }

    public Boolean isJunction() {
        return this.junction;
    }

    public Boolean getJunction() {
        return this.junction;
    }

    public void setJunction(Boolean junction) {
        this.junction = junction;
    }

    public Boolean isNoExit() {
        return this.noExit;
    }

    public Boolean getNoExit() {
        return this.noExit;
    }

    public void setNoExit(Boolean noExit) {
        this.noExit = noExit;
    }

    public Boolean isRailway() {
        return this.railway;
    }

    public Boolean getRailway() {
        return this.railway;
    }

    public void setRailway(Boolean railway) {
        this.railway = railway;
    }

    public Boolean isRoundabout() {
        return this.roundabout;
    }

    public Boolean getRoundabout() {
        return this.roundabout;
    }

    public void setRoundabout(Boolean roundabout) {
        this.roundabout = roundabout;
    }

    public Boolean isStation() {
        return this.station;
    }

    public Boolean getStation() {
        return this.station;
    }

    public void setStation(Boolean station) {
        this.station = station;
    }

    public Boolean isStop() {
        return this.stop;
    }

    public Boolean getStop() {
        return this.stop;
    }

    public void setStop(Boolean stop) {
        this.stop = stop;
    }

    public Boolean isTrafficCalming() {
        return this.trafficCalming;
    }

    public Boolean getTrafficCalming() {
        return this.trafficCalming;
    }

    public void setTrafficCalming(Boolean trafficCalming) {
        this.trafficCalming = trafficCalming;
    }

    public Boolean isTrafficSignal() {
        return this.trafficSignal;
    }

    public Boolean getTrafficSignal() {
        return this.trafficSignal;
    }

    public void setTrafficSignal(Boolean trafficSignal) {
        this.trafficSignal = trafficSignal;
    }

    public Boolean isTurningLoop() {
        return this.turningLoop;
    }

    public Boolean getTurningLoop() {
        return this.turningLoop;
    }

    public void setTurningLoop(Boolean turningLoop) {
        this.turningLoop = turningLoop;
    }

    public String getSunriseSunset() {
        return this.sunriseSunset;
    }

    public void setSunriseSunset(String sunriseSunset) {
        this.sunriseSunset = sunriseSunset;
    }

    public String getCivilTwilight() {
        return this.civilTwilight;
    }

    public void setCivilTwilight(String civilTwilight) {
        this.civilTwilight = civilTwilight;
    }

    public String getNauticalTwilight() {
        return this.nauticalTwilight;
    }

    public void setNauticalTwilight(String nauticalTwilight) {
        this.nauticalTwilight = nauticalTwilight;
    }

    public String getAstronomicalTwilight() {
        return this.astronomicalTwilight;
    }

    public void setAstronomicalTwilight(String astronomicalTwilight) {
        this.astronomicalTwilight = astronomicalTwilight;
    }
}