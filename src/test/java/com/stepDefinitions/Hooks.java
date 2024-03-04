package com.stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	static WebDriver driver;
	

	@BeforeAll
	public static void setup() throws IOException {
		Properties property;
		property = BaseClass.getProperties();
		driver = BaseClass.initilizeBrowser();
		driver.get(property.getProperty("baseUrl"));
		driver.manage().window().maximize();
	}

	@AfterStep
	public void Screenshot(Scenario scenario) {
		if (!scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		else {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
}