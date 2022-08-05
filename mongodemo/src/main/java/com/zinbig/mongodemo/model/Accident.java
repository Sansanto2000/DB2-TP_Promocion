package com.zinbig.mongodemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Accident {

    @Id
    private String id;

    private String ID;
    private String Source;
    private double TMC;
    private double Severity;
    private String Start_Time;
    private String End_Time;
    private double Start_Lat;
    private double Start_Lng;
    @Field("Distance(mi)")
    private double Distance;
    private String Description;
    private String Street;
    private String Side;
    private String City;
    private String County;
    private String State;
    private String Zipcode;
    private String Country;
    private String Timezone;
    private String Airport_Code;
    private String Weather_Timestamp;
    @Field("Temperature(F)")
    private double Temperature;
    @Field("Humidity(%)")
    private double Humidity;
    @Field("Pressure(in)")
    private double Pressure;
    @Field("Visibility(mi)")
    private double Visibility;
    private String Wind_Direction;
    @Field("Precipitation(in)")
    private double Precipitation;
    private String Weather_Condition;
    private String Amenity;
    private String Bump;
    private String Crossing;
    private String Give_Way;
    private String Junction;
    private String No_Exit;
    private String Railway;
    private String Roundabout;
    private String Station;
    private String Stop;
    private String Traffic_Calming;
    private String Traffic_Signal;
    private String Turning_Loop;
    private String Sunrise_Sunset;
    private String Civil_Twilight;
    private String Nautical_Twilight;
    private String Astronomical_Twilight;

    public Accident() {

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public double getTMC() {
        return TMC;
    }

    public void setTMC(double TMC) {
        this.TMC = TMC;
    }

    public double getSeverity() {
        return Severity;
    }

    public void setSeverity(double severity) {
        Severity = severity;
    }

    public String getStart_Time() {
        return Start_Time;
    }

    public void setStart_Time(String start_Time) {
        Start_Time = start_Time;
    }

    public String getEnd_Time() {
        return End_Time;
    }

    public void setEnd_Time(String end_Time) {
        End_Time = end_Time;
    }

    public double getStart_Lat() {
        return Start_Lat;
    }

    public void setStart_Lat(double start_Lat) {
        Start_Lat = start_Lat;
    }

    public double getStart_Lng() {
        return Start_Lng;
    }

    public void setStart_Lng(double start_Lng) {
        Start_Lng = start_Lng;
    }

    public double getDistance() {
        return Distance;
    }

    public void setDistance(double distance) {
        Distance = distance;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getSide() {
        return Side;
    }

    public void setSide(String side) {
        Side = side;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String county) {
        County = county;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getTimezone() {
        return Timezone;
    }

    public void setTimezone(String timezone) {
        Timezone = timezone;
    }

    public String getAirport_Code() {
        return Airport_Code;
    }

    public void setAirport_Code(String airport_Code) {
        Airport_Code = airport_Code;
    }

    public String getWeather_Timestamp() {
        return Weather_Timestamp;
    }

    public void setWeather_Timestamp(String weather_Timestamp) {
        Weather_Timestamp = weather_Timestamp;
    }

    public double getTemperature() {
        return Temperature;
    }

    public void setTemperature(double temperature) {
        Temperature = temperature;
    }

    public double getHumidity() {
        return Humidity;
    }

    public void setHumidity(double humidity) {
        Humidity = humidity;
    }

    public double getPressure() {
        return Pressure;
    }

    public void setPressure(double pressure) {
        Pressure = pressure;
    }

    public double getVisibility() {
        return Visibility;
    }

    public void setVisibility(double visibility) {
        Visibility = visibility;
    }

    public String getWind_Direction() {
        return Wind_Direction;
    }

    public void setWind_Direction(String wind_Direction) {
        Wind_Direction = wind_Direction;
    }

    public double getPrecipitation() {
        return Precipitation;
    }

    public void setPrecipitation(double precipitation) {
        Precipitation = precipitation;
    }

    public String getWeather_Condition() {
        return Weather_Condition;
    }

    public void setWeather_Condition(String weather_Condition) {
        Weather_Condition = weather_Condition;
    }

    public String getAmenity() {
        return Amenity;
    }

    public void setAmenity(String amenity) {
        Amenity = amenity;
    }

    public String getBump() {
        return Bump;
    }

    public void setBump(String bump) {
        Bump = bump;
    }

    public String getCrossing() {
        return Crossing;
    }

    public void setCrossing(String crossing) {
        Crossing = crossing;
    }

    public String getGive_Way() {
        return Give_Way;
    }

    public void setGive_Way(String give_Way) {
        Give_Way = give_Way;
    }

    public String getJunction() {
        return Junction;
    }

    public void setJunction(String junction) {
        Junction = junction;
    }

    public String getNo_Exit() {
        return No_Exit;
    }

    public void setNo_Exit(String no_Exit) {
        No_Exit = no_Exit;
    }

    public String getRailway() {
        return Railway;
    }

    public void setRailway(String railway) {
        Railway = railway;
    }

    public String getRoundabout() {
        return Roundabout;
    }

    public void setRoundabout(String roundabout) {
        Roundabout = roundabout;
    }

    public String getStation() {
        return Station;
    }

    public void setStation(String station) {
        Station = station;
    }

    public String getStop() {
        return Stop;
    }

    public void setStop(String stop) {
        Stop = stop;
    }

    public String getTraffic_Calming() {
        return Traffic_Calming;
    }

    public void setTraffic_Calming(String traffic_Calming) {
        Traffic_Calming = traffic_Calming;
    }

    public String getTraffic_Signal() {
        return Traffic_Signal;
    }

    public void setTraffic_Signal(String traffic_Signal) {
        Traffic_Signal = traffic_Signal;
    }

    public String getTurning_Loop() {
        return Turning_Loop;
    }

    public void setTurning_Loop(String turning_Loop) {
        Turning_Loop = turning_Loop;
    }

    public String getSunrise_Sunset() {
        return Sunrise_Sunset;
    }

    public void setSunrise_Sunset(String sunrise_Sunset) {
        Sunrise_Sunset = sunrise_Sunset;
    }

    public String getCivil_Twilight() {
        return Civil_Twilight;
    }

    public void setCivil_Twilight(String civil_Twilight) {
        Civil_Twilight = civil_Twilight;
    }

    public String getNautical_Twilight() {
        return Nautical_Twilight;
    }

    public void setNautical_Twilight(String nautical_Twilight) {
        Nautical_Twilight = nautical_Twilight;
    }

    public String getAstronomical_Twilight() {
        return Astronomical_Twilight;
    }

    public void setAstronomical_Twilight(String astronomical_Twilight) {
        Astronomical_Twilight = astronomical_Twilight;
    }
}