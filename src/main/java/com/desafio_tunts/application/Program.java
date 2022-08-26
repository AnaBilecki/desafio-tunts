package com.desafio_tunts.application;

import java.util.List;

import org.apache.log4j.BasicConfigurator;

import com.desafio_tunts.entities.Country;
import com.desafio_tunts.services.CountryService;
import com.desafio_tunts.services.ExcelWriterService;

public class Program {

	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		
		ExcelWriterService excelWriter = new ExcelWriterService();
		
		List<Country> countries;
		String excelFilePath = "CountriesList.xlsx";
		
		try {
			countries = CountryService.getAll();
			excelWriter.writeExcel(countries, excelFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
