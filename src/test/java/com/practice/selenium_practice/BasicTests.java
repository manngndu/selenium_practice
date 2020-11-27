package com.practice.selenium_practice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTests {

	@BeforeMethod
	public void setup() {
		System.out.println("Setup the environment");
	}

	@Test
	public void firstTest() {
		System.out.println("First Test is being executed by TestNg");
	}

	@AfterTest
	public void teardown() {
		System.out.println("Clean the mess left behind by the tests");
	}

}
