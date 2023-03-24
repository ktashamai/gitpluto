package MMPLogin.MMPLogin;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelread {

	
		
	
	public static void main(String[] args) throws IOException
	{
		FileInputStream fs = new FileInputStream("/Users/AshaPrathib/loginid.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		//Row row = sheet.getRow(0);
		Row row=sheet.getRow(0);
		System.out.println(sheet.getTabColor());
		Cell cell = row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
		Row row1 = sheet.getRow(1);
		Cell cell1 = row1.getCell(1);
		System.out.println(sheet.getRow(0).getCell(1));
		Row row2 = sheet.getRow(1);
		Cell cell2 = row2.getCell(1);
		System.out.println(sheet.getRow(1).getCell(0));
		Row row3 = sheet.getRow(1);
		Cell cell3 = (Cell) row3.getCell(1);
		System.out.println(sheet.getRow(1).getCell(1));
        Row row4=sheet.getRow(2);
        Cell cell4=row4.getCell(0);
        System.out.println(sheet.getRow(2).getCell(0));
		
        
        Row row5=sheet.getRow(2);
        Cell cell5=row4.getCell(1);
        System.out.println(sheet.getRow(2).getCell(1));
        
        Row row6=sheet.getRow(2);
        Cell cell6=row4.getCell(2);
        System.out.println(sheet.getRow(0).getCell(0));
        System.out.println(sheet.getRow(0).getCell(1));
        System.out.println(sheet.getRow(0).getCell(2));
        System.out.println(sheet.getRow(1).getCell(0));
        System.out.println(sheet.getRow(1).getCell(1));
        System.out.println(sheet.getRow(1).getCell(2));
        System.out.println(sheet.getRow(2).getCell(0));
        System.out.println(sheet.getRow(2).getCell(1));
        System.out.println(sheet.getRow(2).getCell(2));
        System.out.println(sheet.getRow(3).getCell(0));
        System.out.println(sheet.getRow(3).getCell(1));
        System.out.println(sheet.getRow(3).getCell(2));
        System.out.println(sheet.getRow(4).getCell(0));
        System.out.println(sheet.getRow(4).getCell(1));
        System.out.println(sheet.getRow(4).getCell(2));
        
        Row row7=sheet.getRow(5);
        Cell cell7=row.createCell(1);
        cell7.setCellValue("ria chakraborthy");
        
        System.out.println("New added value:"+sheet.getRow(5).getCell(1));
        FileOutputStream fos = new FileOutputStream("/Users/AshaPrathib/loginid.xlsx");
        workbook.write(fos);
        System.out.println("New added value:"+sheet.getRow(5).getCell(1));
       
        fos.close();
	    } 

	    }  


