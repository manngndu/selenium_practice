package com.practice.selenium_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTests {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\practice\\utilities\\chromedriver.exe");		
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

	@Test
	public void titleTest() {
		System.out.println("The title of the page is"+driver.getTitle());
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
