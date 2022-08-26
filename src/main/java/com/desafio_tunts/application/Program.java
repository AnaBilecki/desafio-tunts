package com.desafio_tunts.application;

import com.desafio_tunts.services.CountryService;

public class Program {

	public static void main(String[] args) {
		
		try {
			System.out.println(CountryService.getAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
