package com.mini.project;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OnlineFurnitureStore extends Driversetup {

	static WebDriver driver;
	static int count;
	
	public void readconfigProperties() throws Exception {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ 
				"\\src\\com\\mini\\project\\config properties\\config.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String browser = pro.getProperty("browser");
		String URL = pro.getProperty("baseURL");
		System.out.println(browser + "\n" + URL);
		invokeBrowser(browser, URL);

	}

	public WebDriver invokeBrowser(String browser, String URL) throws Exception { // INVOKE BROWSER
	
		switch (browser) {

		case "chrome":
			driver=getChrome();
			driver.get(URL);
			return driver;
		case "firefox":
			driver= getFirefoxDriver();
			driver.get(URL);
			return driver;
		case "Edge":
			driver=getedgeDriver();
			driver.get(URL);
			return driver;
		}
		return driver;
		
	}

	
	
	public void ValidatepageTitle()// Validate the PageTitle
	{
driver.manage().window().maximize();
		String pageTitle = driver.getTitle();
		Assert.assertEquals(
				pageTitle,
				"Online Furniture Shopping Store: Shop Online in India for Furniture, Home Decor, Homeware Products @ Pepperfry");
	}

	
	public void selectFurniture() throws InterruptedException // Select Furniture and Click on Benches
	{
		driver.findElement(By.xpath("//a[@rel='meta-furniture']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement seats = driver.findElement(By
				.xpath("//div[@class='headerHover__wrap']/div/ul/li[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(seats));
		seats.click();

		WebElement benches = driver.findElement(By
				.xpath("//*[@id='meta-furniture_seating']/ul/li[2]/a"));
		wait.until(ExpectedConditions.elementToBeClickable(benches));
		benches.click();

	}

	
	public void countCategory()// Display the benches with its category and  count
								
	{
		
		List<WebElement> Benches = driver.findElements(By.xpath("//div[@class='clip-cat-wrap']"));
		for (int i = 0; i < Benches.size(); i++) {
			String s = Benches.get(i).getText();
			System.out.println("" + s);
			 count=0;
				while(s.contains("Industrial Benches"))
				{
					count++;
					s=s.substring(s.indexOf("Industrial Benches")+"Industrial Benches".length());
				}
			}
				if(count >=1)
				{
				System.out.println("Industrial Benches are displayed " + count + " time");
				}
				else
					System.out.println("Industrial Benches are not  more than ones");
				}
	

	
	public void closebrowser()// close the browser
	{
		driver.quit();
	}
	

}
