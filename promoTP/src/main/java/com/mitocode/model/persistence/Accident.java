package com.mitocode.model.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Entity
@Table(name = "accident")
@Document(indexName = "accident")
public class Accident {

    @Id
    //@Column(name = "ID")
    private String id;
    @Field("Source")
    @org.springframework.data.elasticsearch.annotations.Field("source")
    private String source;
    @Field("TMC")
    @org.springframework.data.elasticsearch.annotations.Field("tcm")
    private Float tmc;
    @Field("Severity")
    @org.springframework.data.elasticsearch.annotations.Field("severity")
    private Integer severity;
    @Field("Start_Time")
    @org.springframework.data.elasticsearch.annotations.Field("start_time")
    private String startTime;
    @Field("End_Time")
    @org.springframework.data.elasticsearch.annotations.Field("end_time")
    private String endTime;
    @Field("Start_Lat")
    @org.springframework.data.elasticsearch.annotations.Field("start_lat")
    private Float startLat;
    @Field("Start_Lng")
    @org.springframework.data.elasticsearch.annotations.Field("start_lng")
    private Float startLng;
    @Field("End_Lat")
    @org.springframework.data.elasticsearch.annotations.Field("end_lat")
    private Float endLat;
    @Field("End_Lng")
    @org.springframework.data.elasticsearch.annotations.Field("end_lng")
    private Float endLng;
    @Field("Distance(mi)")
    @org.springframework.data.elasticsearch.annotations.Field("distance_mi")
    private Float distanceMi;
    @Field("Description")
    @org.springframework.data.elasticsearch.annotations.Field("description")
    private String description;
    @Field("Number")
    @org.springframework.data.elasticsearch.annotations.Field("number")
    private Float number;
    @Field("Street")
    @org.springframework.data.elasticsearch.annotations.Field(value = "street", type = FieldType.Text, fielddata = true)
    private String street;
    @Field("Side")
    @org.springframework.data.elasticsearch.annotations.Field("side")
    private char side;
    @Field("City")
    @org.springframework.data.elasticsearch.annotations.Field("city")
    private String city;
    @Field("County")
    @org.springframework.data.elasticsearch.annotations.Field("county")
    private String county;
    @Field("State")
    @org.springframework.data.elasticsearch.annotations.Field("state")
    private String state;
    @Field("Zipcode")
    @org.springframework.data.elasticsearch.annotations.Field("zipcode")
    private String zipcode;
    @Field("Country")
    @org.springframework.data.elasticsearch.annotations.Field("country")
    private String country;
    @Field("Timezone")
    @org.springframework.data.elasticsearch.annotations.Field("timezone")
    private String timezone;
    @Field("Airport_Code")
    @org.springframework.data.elasticsearch.annotations.Field("airport_code")
    private String airportCode;
    @Field("Weather_Timestamp")
    @org.springframework.data.elasticsearch.annotations.Field("weather_timestamp")
    private String weatherTimestamp;
    @Field("Temperature(F)")
    @org.springframework.data.elasticsearch.annotations.Field("temperature_f")
    @Column(name = "temperature_f")
    private Float temperatureF;
    @Field("Wind_Chill(F)")
    @org.springframework.data.elasticsearch.annotations.Field("wind_chill_f")
    @Column(name = "wind_chill_f")
    private String windChillF;
    @Field("Humidity(%)")
    @org.springframework.data.elasticsearch.annotations.Field("humidity")
    private String humidity;
    @Field("Pressure(in)")
    @org.springframework.data.elasticsearch.annotations.Field("pressure_in")
    private String pressureIn;
    @Field("Visibility(mi)")
    @org.springframework.data.elasticsearch.annotations.Field("visibility_mi")
    private Float visibilityMi;
    @Field("Wind_Direction")
    @org.springframework.data.elasticsearch.annotations.Field("wind_direction")
    private String windDirection;
    @Field("Wind_Speed(mph)")
    @org.springframework.data.elasticsearch.annotations.Field("wind_speed_mph")
    private Float windSpeedMph;
    @Field("Precipitation(in)")
    @org.springframework.data.elasticsearch.annotations.Field("precipitation_in")
    private Float precipitationIn;
    @Field("Weather_Condition")
    @org.springframework.data.elasticsearch.annotations.Field("weather_condition")
    private String weatherCondition;
    @Field("Amenity")
    @org.springframework.data.elasticsearch.annotations.Field("amenity")
    private Boolean amenity;
    @Field("Bump")
    @org.springframework.data.elasticsearch.annotations.Field("bump")
    private Boolean bump;
    @Field("Crossing")
    @org.springframework.data.elasticsearch.annotations.Field("crossing")
    private Boolean crossing;
    @Field("Give_Way")
    @org.springframework.data.elasticsearch.annotations.Field("give_way")
    private Boolean giveWay;
    @Field("Junction")
    @org.springframework.data.elasticsearch.annotations.Field("junction")
    private Boolean junction;
    @Field("No_Exit")
    @org.springframework.data.elasticsearch.annotations.Field("no_exit")
    private Boolean noExit;
    @Field("Railway")
    @org.springframework.data.elasticsearch.annotations.Field("railway")
    private Boolean railway;
    @Field("Roundabout")
    @org.springframework.data.elasticsearch.annotations.Field("roundabout")
    private Boolean roundabout;
    @Field("Station")
    @org.springframework.data.elasticsearch.annotations.Field("station")
    private Boolean station;
    @Field("Stop")
    @org.springframework.data.elasticsearch.annotations.Field("stop")
    private Boolean stop;
    @Field("Traffic_Calming")
    @org.springframework.data.elasticsearch.annotations.Field("traffic_calming")
    private Boolean trafficCalming;
    @Field("Traffic_Signal")
    @org.springframework.data.elasticsearch.annotations.Field("traffic_signal")
    private Boolean trafficSignal;
    @Field("Turning_Loop")
    @org.springframework.data.elasticsearch.annotations.Field("turning_loop")
    private Boolean turningLoop;
    @Field("Sunrise_Sunset")
    @org.springframework.data.elasticsearch.annotations.Field("sunrise_sunset")
    private String sunriseSunset;
    @Field("Civil_Twilight")
    @org.springframework.data.elasticsearch.annotations.Field("civil_twilight")
    private String civilTwilight;
    @Field("Nautical_Twilight")
    @org.springframework.data.elasticsearch.annotations.Field("nautical_twilight")
    private String nauticalTwilight;
    @Field("Astronomical_Twilight")
    @org.springframework.data.elasticsearch.annotations.Field("astronomical_twilight")
    private String astronomicalTwilight;

    public Accident(){

    }

    public Accident(String id, String source, Float tmc, Integer severity, String startTime, String endTime, Float startLat, Float startLng, Float endLat, Float endLng, Float distanceMi, String description, Float number, String street, char side, String city, String county, String state, String zipcode, String country, String timezone, String airportCode, String weatherTimestamp, Float temperatureF, String windChillF, String humidity, String pressureIn, Float visibilityMi, String windDirection, Float windSpeedMph, Float precipitationIn, String weatherCondition, Boolean amenity, Boolean bump, Boolean crossing, Boolean giveWay, Boolean junction, Boolean noExit, Boolean railway, Boolean roundabout, Boolean station, Boolean stop, Boolean trafficCalming, Boolean trafficSignal, Boolean turningLoop, String sunriseSunset, String civilTwilight, String nauticalTwilight, String astronomicalTwilight) {
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
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Float getTmc() {
        return tmc;
    }

    public void setTmc(Float tmc) {
        this.tmc = tmc;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Float getStartLat() {
        return startLat;
    }

    public void setStartLat(Float startLat) {
        this.startLat = startLat;
    }

    public Float getStartLng() {
        return startLng;
    }

    public void setStartLng(Float startLng) {
        this.startLng = startLng;
    }

    public Float getEndLat() {
        return endLat;
    }

    public void setEndLat(Float endLat) {
        this.endLat = endLat;
    }

    public Float getEndLng() {
        return endLng;
    }

    public void setEndLng(Float endLng) {
        this.endLng = endLng;
    }

    public Float getDistanceMi() {
        return distanceMi;
    }

    public void setDistanceMi(Float distanceMi) {
        this.distanceMi = distanceMi;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getNumber() {
        return number;
    }

    public void setNumber(Float number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public char getSide() {
        return side;
    }

    public void setSide(char side) {
        this.side = side;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getWeatherTimestamp() {
        return weatherTimestamp;
    }

    public void setWeatherTimestamp(String weatherTimestamp) {
        this.weatherTimestamp = weatherTimestamp;
    }

    public Float getTemperatureF() {
        return temperatureF;
    }

    public void setTemperatureF(Float temperatureF) {
        this.temperatureF = temperatureF;
    }

    public String getWindChillF() {
        return windChillF;
    }

    public void setWindChillF(String windChillF) {
        this.windChillF = windChillF;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressureIn() {
        return pressureIn;
    }

    public void setPressureIn(String pressureIn) {
        this.pressureIn = pressureIn;
    }

    public Float getVisibilityMi() {
        return visibilityMi;
    }

    public void setVisibilityMi(Float visibilityMi) {
        this.visibilityMi = visibilityMi;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public Float getWindSpeedMph() {
        return windSpeedMph;
    }

    public void setWindSpeedMph(Float windSpeedMph) {
        this.windSpeedMph = windSpeedMph;
    }

    public Float getPrecipitationIn() {
        return precipitationIn;
    }

    public void setPrecipitationIn(Float precipitationIn) {
        this.precipitationIn = precipitationIn;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public Boolean getAmenity() {
        return amenity;
    }

    public void setAmenity(Boolean amenity) {
        this.amenity = amenity;
    }

    public Boolean getBump() {
        return bump;
    }

    public void setBump(Boolean bump) {
        this.bump = bump;
    }

    public Boolean getCrossing() {
        return crossing;
    }

    public void setCrossing(Boolean crossing) {
        this.crossing = crossing;
    }

    public Boolean getGiveWay() {
        return giveWay;
    }

    public void setGiveWay(Boolean giveWay) {
        this.giveWay = giveWay;
    }

    public Boolean getJunction() {
        return junction;
    }

    public void setJunction(Boolean junction) {
        this.junction = junction;
    }

    public Boolean getNoExit() {
        return noExit;
    }

    public void setNoExit(Boolean noExit) {
        this.noExit = noExit;
    }

    public Boolean getRailway() {
        return railway;
    }

    public void setRailway(Boolean railway) {
        this.railway = railway;
    }

    public Boolean getRoundabout() {
        return roundabout;
    }

    public void setRoundabout(Boolean roundabout) {
        this.roundabout = roundabout;
    }

    public Boolean getStation() {
        return station;
    }

    public void setStation(Boolean station) {
        this.station = station;
    }

    public Boolean getStop() {
        return stop;
    }

    public void setStop(Boolean stop) {
        this.stop = stop;
    }

    public Boolean getTrafficCalming() {
        return trafficCalming;
    }

    public void setTrafficCalming(Boolean trafficCalming) {
        this.trafficCalming = trafficCalming;
    }

    public Boolean getTrafficSignal() {
        return trafficSignal;
    }

    public void setTrafficSignal(Boolean trafficSignal) {
        this.trafficSignal = trafficSignal;
    }

    public Boolean getTurningLoop() {
        return turningLoop;
    }

    public void setTurningLoop(Boolean turningLoop) {
        this.turningLoop = turningLoop;
    }

    public String getSunriseSunset() {
        return sunriseSunset;
    }

    public void setSunriseSunset(String sunriseSunset) {
        this.sunriseSunset = sunriseSunset;
    }

    public String getCivilTwilight() {
        return civilTwilight;
    }

    public void setCivilTwilight(String civilTwilight) {
        this.civilTwilight = civilTwilight;
    }

    public String getNauticalTwilight() {
        return nauticalTwilight;
    }

    public void setNauticalTwilight(String nauticalTwilight) {
        this.nauticalTwilight = nauticalTwilight;
    }

    public String getAstronomicalTwilight() {
        return astronomicalTwilight;
    }

    public void setAstronomicalTwilight(String astronomicalTwilight) {
        this.astronomicalTwilight = astronomicalTwilight;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Accident{" +
                "id='" + id + '\'' +
                ", source='" + source + '\'' +
                ", tmc=" + tmc +
                ", severity=" + severity +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", startLat=" + startLat +
                ", startLng=" + startLng +
                ", endLat=" + endLat +
                ", endLng=" + endLng +
                ", distanceMi=" + distanceMi +
                ", description='" + description + '\'' +
                ", number=" + number +
                ", street='" + street + '\'' +
                ", side=" + side +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", country='" + country + '\'' +
                ", timezone='" + timezone + '\'' +
                ", airportCode='" + airportCode + '\'' +
                ", weatherTimestamp='" + weatherTimestamp + '\'' +
                ", temperatureF=" + temperatureF +
                ", windChillF='" + windChillF + '\'' +
                ", humidity='" + humidity + '\'' +
                ", pressureIn='" + pressureIn + '\'' +
                ", visibilityMi=" + visibilityMi +
                ", windDirection='" + windDirection + '\'' +
                ", windSpeedMph=" + windSpeedMph +
                ", precipitationIn=" + precipitationIn +
                ", weatherCondition='" + weatherCondition + '\'' +
                ", amenity=" + amenity +
                ", bump=" + bump +
                ", crossing=" + crossing +
                ", giveWay=" + giveWay +
                ", junction=" + junction +
                ", noExit=" + noExit +
                ", railway=" + railway +
                ", roundabout=" + roundabout +
                ", station=" + station +
                ", stop=" + stop +
                ", trafficCalming=" + trafficCalming +
                ", trafficSignal=" + trafficSignal +
                ", turningLoop=" + turningLoop +
                ", sunriseSunset='" + sunriseSunset + '\'' +
                ", civilTwilight='" + civilTwilight + '\'' +
                ", nauticalTwilight='" + nauticalTwilight + '\'' +
                ", astronomicalTwilight='" + astronomicalTwilight + '\'' +
                '}';
    }
}