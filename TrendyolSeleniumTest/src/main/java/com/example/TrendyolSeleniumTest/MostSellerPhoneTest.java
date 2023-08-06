package com.example.TrendyolSeleniumTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MostSellerPhoneTest extends DriverManager {

	public static void main(String[] args) throws InterruptedException {
		
		FindProduct findProduct = new FindProduct();
		
		setDriver("chrome");
		
		findProduct.GoPagetWithDivClassName(driver, "modal-close"); //close popup
		
		findProduct.selectObjectWithLink(driver, "a[href='/butik/liste/5/elektronik']"); //Electronic clicked
		
		findProduct.selectObjectWithLink(driver, "a[href='https://www.trendyol.com/sr?wc=109460,109459,109461,104034']"); //phone clicked
		
		findProduct.GoPagetWithDivClassName(driver, "overlay"); //close popup
		
		//Find samsung phone , can do find searchbox
		//findProduct.SearchBox(driver, "samsung");  
		
		//find sort button 
		findProduct.GoPagetWithDivClassName(driver, "search-sort-container");
		
		//wait sort button elements
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		
      	wait.until(ExpectedConditions.presenceOfElementLocated(By.className("search-dropdown")));
		
        //sort button in best seller, Select best seller
        driver.findElement(By.xpath("//li/span[text()='En çok satanlar']")).click();
        
        //Search brand , Select samsung model
        findProduct.selectObjectWithLink(driver, "a[href='/sr?wc=109460,104034,109461,109459&wb=794&sst=BEST_SELLER']");
        
        //wait load product list
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("prdct-cntnr-wrppr")));
        Thread.sleep(2000);
        
        // if you prefer data-id 
        //  WebElement productid = driver.findElement(By.xpath("//div[@data-id='679293925']")); 
        //  WebElement productid = driver.findElement(By.cssSelector("div[data-id='679293925']"));
        
        //Or select product list in best seller
        //get product container element
        WebElement parentElement = driver.findElement(By.className("prdct-cntnr-wrppr"));
        //convert all products to list
		List<WebElement> allChildElements = parentElement .findElements(By.xpath("*"));
		//get first product
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("prdct-cntnr-wrppr")));
		allChildElements.get(0).click();
		
		String currentWindowHandle = driver.getWindowHandle();

		// switch window
		for (String windowHandle : driver.getWindowHandles()) {
		    if (!windowHandle.equals(currentWindowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
        // add to basket
        findProduct.GoPagetWithDivClassName(driver, "add-to-basket-button-text"); 
        //wait for add
        Thread.sleep(2000);
        //go basket
        findProduct.GoPagetWithDivClassName(driver, "goBasket");  
        //close popup
        driver.findElement(By.xpath("//div/button[text()='Anladım']")).click();
        //delete product
        findProduct.GoPagetWithDivClassName(driver, "i-trash");
	}
	

}
