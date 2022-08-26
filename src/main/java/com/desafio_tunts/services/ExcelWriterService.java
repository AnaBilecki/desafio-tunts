package com.desafio_tunts.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.desafio_tunts.entities.Country;

public class ExcelWriterService {

	public void writeExcel(List<Country> countries, String path) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Countries List");

		int rowCount = 0;

		for (Country country : countries) {
			XSSFRow row = sheet.createRow(++rowCount);
			writeCountry(country, row);
		}

		try (FileOutputStream outputStream = new FileOutputStream(path)) {
			workbook.write(outputStream);
		}
		
		workbook.close();
	}
	
	private void writeCountry(Country country, XSSFRow row) {

		XSSFCell cell = (XSSFCell) row.createCell(0);
		cell.setCellValue(country.getName().getCommon());

		cell = (XSSFCell) row.createCell(1);
		
		if (country.getCapital() != null) {
			cell.setCellValue(country.getCapital().get(0));
		} else {
			cell.setCellValue("-");
		}
		
		cell = (XSSFCell) row.createCell(2);
		cell.setCellValue(country.getArea());
		
		cell = (XSSFCell) row.createCell(3);
		
		if (country.getCurrencies() != null) {
			cell.setCellValue(country.getCurrencies().keySet().toString());
		} else {
			cell.setCellValue("-");
		}
	}
}
