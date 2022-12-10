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

public class wikipedia {
	

	WebDriver driver;
	
	@BeforeTest
   public void setup () throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		
		driver.manage().window().maximize();
		
		waitforWebElement();
	}
	
	
	@Test
	public void ExtractData() throws InterruptedException {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,500)");
		
		WebElement releaseDate=	driver.findElement(By.xpath("//div[text()='Release date']"));

		System.out.println(releaseDate.getText());
		
		waitforWebElement();
		
		WebElement Date= driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[12]/td/div/ul/li"));

		System.out.println(Date.getText());
		
		waitforWebElement();
		
		WebElement contry=	driver.findElement(By.xpath("//th[text()='Country']"));

		System.out.println(contry.getText());
		
		waitforWebElement();
		
		WebElement contryname=	driver.findElement(By.xpath("//td[text()='India']"));

		System.out.println(contryname.getText());
		
		waitforWebElement();
		
	}
	
  public void waitforWebElement() throws InterruptedException {
		
		Thread.sleep(3000);
		
	}

  @AfterTest
  public void Close_browser() {
	driver.quit();
}

}
