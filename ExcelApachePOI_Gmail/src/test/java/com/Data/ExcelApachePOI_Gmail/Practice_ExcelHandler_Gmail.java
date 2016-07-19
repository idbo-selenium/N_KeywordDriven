package com.Data.ExcelApachePOI_Gmail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class Practice_ExcelHandler_Gmail {

	@Test
	public void ExcelHandler(){
		try {
			FileInputStream mercuryFile = new FileInputStream("GmailLogin.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(mercuryFile);
			XSSFSheet testcasesSheet = workbook.getSheet("Test_Cases");
			XSSFSheet loginSheet = workbook.getSheet("Gmail_Login");
			
			int testcasesSheetRows = testcasesSheet.getLastRowNum();
			System.out.println("testcasesSheetRows : "+testcasesSheetRows);
			
			int loginSheetRows = loginSheet.getLastRowNum();
			System.out.println("loginSheetRows : "+loginSheetRows);
			
			GmailTest gmail = new GmailTest();
			Method gmailMethods[] = gmail.getClass().getMethods();
			
			for(int i=1;i<=testcasesSheetRows;i++){
				String testcasesSheet_TestID = String.valueOf(testcasesSheet.getRow(i).getCell(0));
				String testcasesSheet_Type = String.valueOf(testcasesSheet.getRow(i).getCell(2));
				if(testcasesSheet_Type.equals("Yes")){
					for(int j=1;j<=loginSheetRows;j++){
						String loginSheet_TestID = String.valueOf(loginSheet.getRow(j).getCell(0));
						if(testcasesSheet_TestID.equals(loginSheet_TestID)){
							String loginSheet_Object = String.valueOf(loginSheet.getRow(j).getCell(2));
							String loginSheet_Action = String.valueOf(loginSheet.getRow(j).getCell(3));
							String loginSheet_Data = String.valueOf(loginSheet.getRow(j).getCell(4));
							System.out.println(loginSheet_Object+" , "+loginSheet_Action+" , "+loginSheet_Data);
							for(int k=0;k<gmailMethods.length;k++){
								if(gmailMethods[k].getName().equals(loginSheet_Action)){
									gmailMethods[k].invoke(gmail, loginSheet_Object,loginSheet_Data);
									System.out.println("gmailMethods[k].getName : "+gmailMethods[k].getName());
								}
							}
						}
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}