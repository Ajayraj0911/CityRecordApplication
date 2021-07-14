package com.Bean;

public class CityBean {

	private String city;
	private int morntemp;
	private int eventemp;
	private int nighttemp;
	private int avgtemp;
	
	
	public int getAvgtemp() {
		return avgtemp;
	}
	public void setAvgtemp(int avgtemp) {
		this.avgtemp = avgtemp;
	}
	public String getCity() {
		return city;
	}
	public int getMorntemp() {
		return morntemp;
	}
	public int getEventemp() {
		return eventemp;
	}
	public int getNighttemp() {
		return nighttemp;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setMorntemp(int morntemp) {
		this.morntemp = morntemp;
	}
	public void setEventemp(int eventemp) {
		this.eventemp = eventemp;
	}
	public void setNighttemp(int nighttemp) {
		this.nighttemp = nighttemp;
	}
	
	
	
	
}
