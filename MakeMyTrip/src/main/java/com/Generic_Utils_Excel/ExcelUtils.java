package com.Generic_Utils_Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	public FileInputStream fi;
	public Workbook workbook;
	public Sheet sheet;
	public Row row;
	public Cell cell;
	
	String path=Iframeconstant.ExcelFilepath;
	
	
	public String getcelldata(String sheetname , int rownum , int cellnum)throws Throwable
	{
		fi=new FileInputStream(path);
		workbook=WorkbookFactory.create(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		
		DataFormatter formatter= new DataFormatter();
		
		String data;
		try
		{
			data= formatter.formatCellValue(cell);//this will convert any value to string
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fi.close();
		return data;
	}
}
