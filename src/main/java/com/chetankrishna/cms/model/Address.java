package com.chetankrishna.cms.model;

public class Address {

	private String houseNumber;
	private String streetOne;
	private String streetTwo;
	private String city;
	private String state;
	private String country;
	private String countryCode;
	private String pinCode;
	
	public Address() {
		super();
	}
	
	public Address(String houseNumber, String streetOne, String streetTwo, String city, String state, String country,
			String countryCode, String pinCode) {
		super();
		this.houseNumber = houseNumber;
		this.streetOne = streetOne;
		this.streetTwo = streetTwo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.countryCode = countryCode;
		this.pinCode = pinCode;
	}
	
	public String getHouseNumber() {
		return houseNumber;
	}
	
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	public String getStreetOne() {
		return streetOne;
	}
	
	public void setStreetOne(String streetOne) {
		this.streetOne = streetOne;
	}
	
	public String getStreetTwo() {
		return streetTwo;
	}
	
	public void setStreetTwo(String streetTwo) {
		this.streetTwo = streetTwo;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getPinCode() {
		return pinCode;
	}
	
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", streetOne=" + streetOne + ", streetTwo=" + streetTwo
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", countryCode=" + countryCode
				+ ", pinCode=" + pinCode + "]";
	}
}
