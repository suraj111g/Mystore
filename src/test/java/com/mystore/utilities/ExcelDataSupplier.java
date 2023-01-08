package com.mystore.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSupplier {
    @DataProvider
	public String[][] getData() throws Exception {

		File excelfile = new File("C:\\Users\\Admin\\eclipse-workspace\\Mystore_V1\\src\\main\\resources\\LoginTest.xlsx");
		System.out.println(excelfile.exists());
		FileInputStream fis = new FileInputStream(excelfile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColoums = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[noOfRows-1][noOfColoums];
		for (int i = 0; i < noOfRows-1; i++) {
			for (int j = 0; j < noOfColoums; j++) {
			DataFormatter df = new DataFormatter();
			data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}

		workbook.close();
		fis.close();
		for (String[] strings : data) {
			System.out.println(Arrays.toString(strings));
			
		
			
		}
		return data;

	}
	
	

}
