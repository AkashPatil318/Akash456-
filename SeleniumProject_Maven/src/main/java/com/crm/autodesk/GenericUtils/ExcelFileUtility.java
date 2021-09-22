package com.crm.autodesk.GenericUtils;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

/**
 * 
 * @author Akash
 *
 */

public class ExcelFileUtility {
/**
 * this method will read data from excel sheet
 * @throws Throwable 
 */
	public String getExcelData(String sheetname, int rownum, int cellnum) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		//DataFormatter format = new DataFormatter();
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value=cell.getStringCellValue();	
		return value;
		//return format.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		//String data = format.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		//return data;
	}
		
	

	public Object[][] getExcelData(String Sheetname) throws Throwable
		{

			FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
			Workbook book = WorkbookFactory.create(fis);
			Sheet Sh = book.getSheet(Sheetname);
			int lastrow = Sh.getLastRowNum();
			int lastcell = Sh.getRow(0).getLastCellNum();
			
			Object[][] data = new Object[lastrow][lastcell];
			for(int i=0; i<lastrow;i++) 
			{
				for(int j=0;j<lastcell;j++) 
				{
					data[i][j]=Sh.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
			return data;
		
	}
}
