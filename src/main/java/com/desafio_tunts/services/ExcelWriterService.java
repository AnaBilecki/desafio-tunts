package com.desafio_tunts.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.desafio_tunts.entities.Country;

public class ExcelWriterService {
	
	public static final XSSFColor BLACK = new XSSFColor(new java.awt.Color(0, 0, 0), null);
	public static final XSSFColor DARK_GREY = new XSSFColor(new java.awt.Color(79, 79, 79), null);
	public static final XSSFColor LIGHT_GREY = new XSSFColor(new java.awt.Color(128, 128, 128), null);

	public void writeExcel(List<Country> countries, String path) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Countries List");

		createTitleRow(sheet);
		createHeaderRow(sheet);
		setColumnsWidth(sheet);
		
		XSSFCellStyle mainStyle = createStyle(sheet, false, 11, BLACK, HorizontalAlignment.LEFT);
		setBorders(mainStyle);
		
		XSSFCellStyle areaStyle = createStyle(sheet, false, 11, BLACK, HorizontalAlignment.RIGHT);
		areaStyle.setDataFormat((short) 4);
		setBorders(areaStyle);
		
		int rowCount = 1;

		for (Country country : countries) {
			XSSFRow row = sheet.createRow(++rowCount);
			writeCountry(country, row);
			for (int i = 0; i <= 3; i++) {
				if (i == 2) {
					row.getCell(i).setCellStyle(areaStyle);
				} else {
					row.getCell(i).setCellStyle(mainStyle);
				}
			}
		}

		try (FileOutputStream outputStream = new FileOutputStream(path)) {
			workbook.write(outputStream);
		}
		
		workbook.close();
	}
	
	private XSSFCellStyle createStyle(XSSFSheet sheet, boolean bold, int height, XSSFColor color, HorizontalAlignment alignment) {
		
		XSSFCellStyle style = (XSSFCellStyle) sheet.getWorkbook().createCellStyle();
		
		XSSFFont font = sheet.getWorkbook().createFont();
		font.setBold(bold);
		font.setFontHeightInPoints((short) height);
		font.setColor(color);
		
		style.setFont(font);
		style.setAlignment(alignment);
		
		return style;
	}

	private void createTitleRow(XSSFSheet sheet) {
		
		XSSFCellStyle titleStyle = createStyle(sheet, true, 16, DARK_GREY, HorizontalAlignment.CENTER);
		
		XSSFRow row = sheet.createRow(0);
		XSSFCell cellName = row.createCell(0);
		cellName.setCellStyle(titleStyle);
		cellName.setCellValue("Countries List");
		
		CellRangeAddress rangeAddress = new CellRangeAddress(0, 0, 0, 3);
		sheet.addMergedRegion(rangeAddress);
		
		setBorderMergedRegion(sheet);
	}

	private void createHeaderRow(XSSFSheet sheet) {
		
		XSSFCellStyle headerStyle = createStyle(sheet, true, 12, LIGHT_GREY, HorizontalAlignment.LEFT);
		setBorders(headerStyle);
		
		XSSFRow row = sheet.createRow(1);

		XSSFCell cellName = row.createCell(0);
		cellName.setCellStyle(headerStyle);
		cellName.setCellValue("Name");

		XSSFCell cellCapital = row.createCell(1);
		cellCapital.setCellStyle(headerStyle);
		cellCapital.setCellValue("Capital");

		XSSFCell cellArea = row.createCell(2);
		cellArea.setCellStyle(headerStyle);
		cellArea.setCellValue("Area");

		XSSFCell cellCurrencies = row.createCell(3);
		cellCurrencies.setCellStyle(headerStyle);
		cellCurrencies.setCellValue("Currencies");
	}
	
	private void setColumnsWidth(XSSFSheet sheet) {
		
		sheet.setColumnWidth(0, 15 * 256);
		sheet.setColumnWidth(1, 15 * 256);
		sheet.setColumnWidth(2, 15 * 256);
		sheet.setColumnWidth(3, 15 * 256);
	}
	
	private void setBorders(XSSFCellStyle style) {

		style.setBorderTop(BorderStyle.THIN);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
	}
	
	private void setBorderMergedRegion(XSSFSheet sheet) {
		
		int numMerged = sheet.getNumMergedRegions();
		
		for (int i = 0; i < numMerged; i++) {
			CellRangeAddress mergedRegions = sheet.getMergedRegion(i);
			RegionUtil.setBorderBottom(BorderStyle.THIN, mergedRegions, sheet);
			RegionUtil.setBorderTop(BorderStyle.THIN, mergedRegions, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, mergedRegions, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, mergedRegions, sheet);
		}	
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
			cell.setCellValue(country.getCurrenciesList());
		} else {
			cell.setCellValue("-");
		}
	}
}
