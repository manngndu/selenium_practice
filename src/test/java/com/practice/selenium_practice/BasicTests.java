package com.practice.selenium_practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTests {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws MalformedURLException {		
		DesiredCapabilities	desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setBrowserName("chrome");		
		desiredCapabilities.setPlatform(Platform.WIN10);
		
		ChromeOptions options = new ChromeOptions();
		options.merge(options);		
		
		String hubUrl = "http://192.168.225.169:4444/wd/hub";		
		driver = new RemoteWebDriver(new URL(hubUrl),options);		
		
	}

	@Test
	public void titleTest() {	
		System.out.println("Title Test is executed by Thread =>"+Thread.currentThread().getName()+"-----------"+Thread.currentThread().getId());
		driver.get("https://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());		
	}

	@Test
	public void searchBarTest() {	
		driver.get("https://www.google.com");
		System.out.println("SearchBar Test is executed by Thread =>"+Thread.currentThread().getName()+"-----------"+Thread.currentThread().getId());
		WebElement searchBar = driver.findElement(By.name("q"));
		Assert.assertTrue(searchBar.isDisplayed());		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
