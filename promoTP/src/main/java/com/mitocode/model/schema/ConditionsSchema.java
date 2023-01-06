package com.mitocode.model.schema;

import java.util.Objects;

public class ConditionsSchema {

    private String startTime;
    private String endTime;
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
	
    public ConditionsSchema() {
		super();
	}

	public ConditionsSchema(String startTime, String endTime, Float temperatureF, String windChillF, String humidity,
			String pressureIn, Float visibilityMi, String windDirection, Float windSpeedMph, Float precipitationIn,
			String weatherCondition, Boolean amenity, Boolean bump, Boolean crossing, Boolean giveWay, Boolean junction,
			Boolean noExit, Boolean railway, Boolean roundabout, Boolean station, Boolean stop, Boolean trafficCalming,
			Boolean trafficSignal, Boolean turningLoop, String sunriseSunset, String civilTwilight,
			String nauticalTwilight, String astronomicalTwilight) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
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

	@Override
	public int hashCode() {
		return Objects.hash(amenity, astronomicalTwilight, bump, civilTwilight, crossing, endTime, giveWay, humidity,
				junction, nauticalTwilight, noExit, precipitationIn, pressureIn, railway, roundabout, startTime,
				station, stop, sunriseSunset, temperatureF, trafficCalming, trafficSignal, turningLoop, visibilityMi,
				weatherCondition, windChillF, windDirection, windSpeedMph);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConditionsSchema other = (ConditionsSchema) obj;
		return Objects.equals(amenity, other.amenity)
				&& Objects.equals(astronomicalTwilight, other.astronomicalTwilight) && Objects.equals(bump, other.bump)
				&& Objects.equals(civilTwilight, other.civilTwilight) && Objects.equals(crossing, other.crossing)
				&& Objects.equals(endTime, other.endTime) && Objects.equals(giveWay, other.giveWay)
				&& Objects.equals(humidity, other.humidity) && Objects.equals(junction, other.junction)
				&& Objects.equals(nauticalTwilight, other.nauticalTwilight) && Objects.equals(noExit, other.noExit)
				&& Objects.equals(precipitationIn, other.precipitationIn)
				&& Objects.equals(pressureIn, other.pressureIn) && Objects.equals(railway, other.railway)
				&& Objects.equals(roundabout, other.roundabout) && Objects.equals(startTime, other.startTime)
				&& Objects.equals(station, other.station) && Objects.equals(stop, other.stop)
				&& Objects.equals(sunriseSunset, other.sunriseSunset)
				&& Objects.equals(temperatureF, other.temperatureF)
				&& Objects.equals(trafficCalming, other.trafficCalming)
				&& Objects.equals(trafficSignal, other.trafficSignal) && Objects.equals(turningLoop, other.turningLoop)
				&& Objects.equals(visibilityMi, other.visibilityMi)
				&& Objects.equals(weatherCondition, other.weatherCondition)
				&& Objects.equals(windChillF, other.windChillF) && Objects.equals(windDirection, other.windDirection)
				&& Objects.equals(windSpeedMph, other.windSpeedMph);
	}
       
}