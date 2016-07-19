package com.Data.ExcelApachePOI_Gmail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ExcelHandler_ApachePOI {

	@Test
	public void gmail_ExcelHandler(){
		try {
			FileInputStream gmail = new FileInputStream("GmailLogin.xlsx");
			XSSFWorkbook gmailWorkBook = new XSSFWorkbook(gmail);
			XSSFSheet gmail_testcasesSheet = gmailWorkBook.getSheet("Test_Cases");
			XSSFSheet gmail_loginSheet = gmailWorkBook.getSheet("Gmail_Login");
			
			int testcasesSheet_rows = gmail_testcasesSheet.getLastRowNum();
			System.out.println("testcasesSheet_rows : "+testcasesSheet_rows);			
			
			int gmailloginSheet_rows = gmail_loginSheet.getLastRowNum();
			System.out.println("gmailSheet_rows : "+gmailloginSheet_rows);
			
			GmailLoginTest gmailTest = new GmailLoginTest();
			Method gmailTest_methods[] = gmailTest.getClass().getMethods();
			for(int i=1;i<=testcasesSheet_rows;i++){
				String testcaseSheet_TestID = String.valueOf(gmail_testcasesSheet.getRow(i).getCell(0));
				String testcaseSheet_Type = String.valueOf(gmail_testcasesSheet.getRow(i).getCell(2));
				if(testcaseSheet_Type.equals("Yes")){
					for(int j=1;j<=gmailloginSheet_rows;j++){
						String loginSheet_TestID = String.valueOf(gmail_loginSheet.getRow(j).getCell(0));
						if(testcaseSheet_TestID.equals(loginSheet_TestID)){
							String gmail_Object = String.valueOf(gmail_loginSheet.getRow(j).getCell(2));
							String gmail_Action = String.valueOf(gmail_loginSheet.getRow(j).getCell(3));
							String gmail_Value = String.valueOf(gmail_loginSheet.getRow(j).getCell(4));
							
							for(int k=0;k<gmailTest_methods.length;k++){								
								if(gmail_Action.equalsIgnoreCase(gmailTest_methods[k].getName())){
									gmailTest_methods[k].invoke(gmailTest, gmail_Object,gmail_Value);									
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