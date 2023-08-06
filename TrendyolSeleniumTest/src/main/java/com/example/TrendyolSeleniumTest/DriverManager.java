package com.example.TrendyolSeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
		public static WebDriver driver;
		
		public static void setDriver(String drivername) {
			
			if (drivername=="chrome") {
				System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("start-maximized");
				driver = new ChromeDriver();
				driver.get("https://www.trendyol.com/");
				System.out.println("***** BROWSER IS CHROME *****");
			}
			else if (drivername=="firefox") {
				System.out.println("***** BROWSER IS FIREFOX *****");
			}
			else {
				System.out.println("***** BROWSER NOT FOUND PLEASE CHECK DRIVER NAME *****");
			}
		}
		
}
