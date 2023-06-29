package com.cs.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

	private static FileInputStream fis = null;
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	public static Object[] obj = null;
	
	public static XSSFSheet getExcelData(String sheetName) {
		String fileName = System.getProperty("user.dir") 
				+ "/src/test/resources/linkedInTestData/loginTestData.xlsx";
		try {
			fis = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("unable to find Excel file " + fileName);
		}
		
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			throw new RuntimeException("unable to find Excel file " + workbook);
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		try {
			fis.close();
		} catch (IOException e) {
			throw new RuntimeException("unable to find Excel file sheet " + sheetName);
		}
		return sheet;
	}

	@DataProvider(name="loginData")
	public static Object[] getLoginData() {
		sheet = getExcelData("login");
		int row = sheet.getLastRowNum();
		obj = new Object[row];
		String username = sheet.getRow(0).getCell(0).getStringCellValue();
		String password = sheet.getRow(0).getCell(1).getStringCellValue();
		Map<String, String> map = new HashMap<>();
		for (int r = 0; r < row; r++) {
			map = new HashMap<>();
			String value1 = sheet.getRow(r + 1).getCell(0).getStringCellValue();
			String value2 = sheet.getRow(r + 1).getCell(1).getStringCellValue();
			map.put(username, value1);
			map.put(password, value2);
			obj[r] = map;
		}
		return obj;
		//return new Object[] { map };
	}
	
	@DataProvider(name="jobData")
	public static Object[] getJobData() {
		sheet = getExcelData("jobSearch");
		int row = sheet.getLastRowNum();
		obj = new Object[row];
		String username = sheet.getRow(0).getCell(0).getStringCellValue();
		String password = sheet.getRow(0).getCell(1).getStringCellValue();
		String jobName = sheet.getRow(0).getCell(2).getStringCellValue();
		String jobLocation = sheet.getRow(0).getCell(3).getStringCellValue();
		String experienceLevel = sheet.getRow(0).getCell(4).getStringCellValue();
		String companyName = sheet.getRow(0).getCell(5).getStringCellValue();
		Map<String, String> map;
		for (int r = 0; r < row; r++) {
			map = new HashMap<>();
			String value1 = sheet.getRow(r + 1).getCell(0).getStringCellValue();
			String value2 = sheet.getRow(r + 1).getCell(1).getStringCellValue();
			String value3 = sheet.getRow(r + 1).getCell(2).getStringCellValue();
			String value4 = sheet.getRow(r + 1).getCell(3).getStringCellValue();
			String value5 = sheet.getRow(r + 1).getCell(4).getStringCellValue();
			String value6 = sheet.getRow(r + 1).getCell(5).getStringCellValue();
			map.put(username, value1);
			map.put(password, value2);
			map.put(jobName, value3);
			map.put(jobLocation, value4);
			map.put(experienceLevel, value5);
			map.put(companyName, value6);
			obj[r] = map;
		}
		return obj;
	}
		
	
}
