package com.mitocode.model.schema;

public class ConditionsSchema {

    private Float tmc;
    private Integer severity;
    private String startTime;
    private String endTime;
    private Float startLat;
    private Float startLng;
    private Float endLat;
    private Float endLng;
    private Float distanceMi;
    private Float number;
    private String street;
    private char side;
    private String city;
    private String county;
    private String state;
    private String zipcode;
    private String country;
    private String timezone;
    private String airportCode;
    private String weatherTimestamp;
    private Float temperatureF;
    private String windChillF;
    private String humidity;
    private String pressureIn;
    private Float visibilityMi;
    private String windDirection;
    private Float windSpeedMph;
    private Float precipitationIn;
    private String weatherCondition;
    private Boolean amenity;
    private Boolean bump;
    private Boolean crossing;
    private Boolean giveWay;
    private Boolean junction;
    private Boolean noExit;
    private Boolean railway;
    private Boolean roundabout;
    private Boolean station;
    private Boolean stop;
    private Boolean trafficCalming;
    private Boolean trafficSignal;
    private Boolean turningLoop;
    private String sunriseSunset;
    private String civilTwilight;
    private String nauticalTwilight;
    private String astronomicalTwilight;

    public ConditionsSchema(){

    }

    public ConditionsSchema(Float tmc, Integer severity, String startTime, String endTime, Float startLat, Float startLng, Float endLat, Float endLng, Float distanceMi, Float number, String street, char side, String city, String county, String state, String zipcode, String country, String timezone, String airportCode, String weatherTimestamp, Float temperatureF, String windChillF, String humidity, String pressureIn, Float visibilityMi, String windDirection, Float windSpeedMph, Float precipitationIn, String weatherCondition, Boolean amenity, Boolean bump, Boolean crossing, Boolean giveWay, Boolean junction, Boolean noExit, Boolean railway, Boolean roundabout, Boolean station, Boolean stop, Boolean trafficCalming, Boolean trafficSignal, Boolean turningLoop, String sunriseSunset, String civilTwilight, String nauticalTwilight, String astronomicalTwilight) {
        this.tmc = tmc;
        this.severity = severity;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startLat = startLat;
        this.startLng = startLng;
        this.endLat = endLat;
        this.endLng = endLng;
        this.distanceMi = distanceMi;
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
        return "Conditions{" +
                "tmc=" + tmc +
                ", severity=" + severity +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", startLat=" + startLat +
                ", startLng=" + startLng +
                ", endLat=" + endLat +
                ", endLng=" + endLng +
                ", distanceMi=" + distanceMi +
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