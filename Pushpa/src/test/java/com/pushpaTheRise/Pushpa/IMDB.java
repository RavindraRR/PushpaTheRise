package com.pushpaTheRise.Pushpa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDB {
	
	WebDriver driver;
	
	@BeforeTest
public void setup () throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get("https://www.imdb.com/title/tt9389998/");
		
		driver.manage().window().maximize();
		
		waitforWebElement();
	}
	
	@Test
	public void extractData() throws InterruptedException {
		
WebElement detail=driver.findElement(By.xpath("//span[text()='Details']"));

	JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();", detail);
		
WebElement releaseDate=	driver.findElement(By.xpath("//a[text()='Release date']"));

System.out.println(releaseDate.getText());

waitforWebElement();
		
WebElement Date= driver.findElement(By.xpath("//a[text()='December 17, 2021 (United States)']"));

System.out.println(Date.getText());

waitforWebElement();

WebElement contry= driver.findElement(By.xpath("//button[text()='Country of origin']"));

System.out.println(contry.getText());

waitforWebElement();

WebElement contryname= driver.findElement(By.xpath("//a[text()='India']"));

System.out.println(contryname.getText());

waitforWebElement();

 }
	
	@AfterTest
	public void Close_browser() {
		driver.quit();
	}
	
	public void waitforWebElement() throws InterruptedException {
		
		Thread.sleep(3000);
		
	}
	

}
