package com.Data.ExcelApachePOI_Gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginTest {

	public WebDriver driver;
	public int seconds = 4000;
	
	public WebElement WaitforElement(By locator,int seconds){
		return(new WebDriverWait(driver,seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void OpenBrowser(String s,String d)throws Exception{
		driver = new FirefoxDriver();	
		Thread.sleep(4000);
	}
	
	public void Navigate_To(String s,String d)throws Exception{
		Thread.sleep(4000);
		driver.navigate().to("https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail#identifier");
	}
	
	public void Wait_For(String s,String d)throws Exception{
		Thread.sleep(4000);
	}
	
	public  void Enter_Username(String s,String d){		
		WaitforElement(By.id(s), seconds).sendKeys(d);
	}
	
	public void Click_NextButton(String s,String d){		
		WaitforElement(By.id(s), seconds).click();
	}
	
	public void Enter_Password(String s,String d){		
		WaitforElement(By.id(s), seconds).sendKeys(d);
	}
	
	public void Click_SignIn(String s,String d){		
		WaitforElement(By.id(s), seconds).click();
	}
	
	public void Click_Profile(String s,String d){
		WaitforElement(By.xpath(s), seconds).click();
	}
	
	public void Click_SignOut(String s,String d){
		WaitforElement(By.xpath(s), seconds).click();
	}
	
	public void CloseBrowser(String s,String d){
		driver.close();
	}
}