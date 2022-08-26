package com.desafio_tunts.entities;

public class CountryName {

	private String common;
	
	public CountryName() {
	}

	public CountryName(String common) {
		this.common = common;
	}

	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

	@Override
	public String toString() {
		return common;
	}	
}
