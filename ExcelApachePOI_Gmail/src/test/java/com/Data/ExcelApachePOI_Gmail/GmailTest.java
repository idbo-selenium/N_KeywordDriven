package com.Data.ExcelApachePOI_Gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailTest {

	public WebDriver driver;
	
	public void OpenBrowser(String s,String d){
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Eclipse_Selenium\\Java_Selenium_Maven\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void Navigate_To(String s,String d){
		driver.get("https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Ftab%3Dwm&hl=en&service=mail#identifier");
	}
	
	public void Wait_For(String s,String d)throws Exception{
		Thread.sleep(4000);
	}
	
	public void Enter_Username(String s,String d)throws Exception{
		driver.findElement(By.id(s)).sendKeys(d);
		Thread.sleep(4000);
	}
	
	public void Click_NextButton(String s,String d)throws Exception{
		driver.findElement(By.id(s)).click();
		Thread.sleep(4000);
	}
	
	public void Enter_Password(String s,String d)throws Exception{
		driver.findElement(By.id(s)).sendKeys(d);
		Thread.sleep(4000);
	}
	
	public void Click_SignIn(String s,String d)throws Exception{
		driver.findElement(By.id(s)).click();
		Thread.sleep(4000);
	}
	
	public void Click_Profile(String s,String d)throws Exception{
		driver.findElement(By.xpath(s)).click();
		Thread.sleep(4000);
	}
	
	public void Click_SignOut(String s,String d)throws Exception{
		driver.findElement(By.xpath(s)).click();
		Thread.sleep(4000);
	}
	
	public void CloseBrowser(String s,String d){
		driver.close();
	}
}