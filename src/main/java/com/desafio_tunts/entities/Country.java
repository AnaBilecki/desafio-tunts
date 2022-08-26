package com.desafio_tunts.entities;

import java.util.HashMap;
import java.util.List;

import com.google.gson.JsonObject;

public class Country implements Comparable<Country> {

	private CountryName name;
	private List<String> capital;
	private Double area;
	private HashMap<String, JsonObject> currencies;
	
	public Country() {
	}

	public Country(CountryName name, List<String> capital, Double area, HashMap<String, JsonObject> currencies) {
		this.name = name;
		this.capital = capital;
		this.area = area;
		this.currencies = currencies;
	}

	public CountryName getName() {
		return name;
	}

	public void setName(CountryName name) {
		this.name = name;
	}

	public List<String> getCapital() {
		return capital;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public HashMap<String, JsonObject> getCurrencies() {
		return currencies;
	}

	@Override
	public String toString() {
		return "name = " + name + ", capital = " + capital + ", area = " + area + ", currencies = " + currencies;
	}

	public int compareTo(Country o) {
		return this.getName().getCommon().compareTo(o.getName().getCommon());
	}
}
