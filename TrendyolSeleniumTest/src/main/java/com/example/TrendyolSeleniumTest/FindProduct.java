package com.example.TrendyolSeleniumTest;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FindProduct {
	
	public void selectObjectWithLink (WebDriver driver , String searchKey) {
		WebElement searchElement = driver.findElement(By.cssSelector(searchKey));
		searchElement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	}
	public void GoPagetWithDivClassName (WebDriver driver , String searchKey) {
		WebElement searchElement = driver.findElement(By.className(searchKey));
		searchElement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	}
	public void SearchBox (WebDriver driver , String searchKey) {
		WebElement searchElement = driver.findElement(By.className("V8wbcUhU"));
		searchElement.sendKeys(searchKey);
		searchElement.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	}
	
}
