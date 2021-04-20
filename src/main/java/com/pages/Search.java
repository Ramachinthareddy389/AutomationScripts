/**
 * 
 */
package com.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



/**
 * @author rama.chinthareddy
 *
 */
public class Search {
    WebDriver driver;
    
	By searchBox=By.id("twotabsearchtextbox");
	By buttonSearch=By.id("nav-search-submit-button");
	By phoneLink=By.linkText("New Apple iPhone 11 (128GB) - White");
	By labelManfact=By.cssSelector("#productDetails_techSpec_section_1>tbody>tr:nth-child(1)>td");
	By labelDimen=By.cssSelector("#productDetails_techSpec_section_1>tbody>tr:nth-child(5)>td");
	By labelASIN=By.cssSelector("#productDetails_techSpec_section_1>tbody>tr:nth-child(6)>td");
	By addingCart=By.id("add-to-cart-button");
	By labeladdedcart=By.cssSelector("#huc-v2-order-row-confirm-text>h1");
	By cartContainer=By.id("nav-cart-text-container");
	By cartHeader=By.cssSelector(".a-row.sc-cart-header.sc-compact-bottom>div>h1");
	By productAddedToCart=By.linkText("New Apple iPhone 11 (128GB) - White");
	
	
	public void searchingProduct(String productName)
	{
		driver.findElement(searchBox).sendKeys(productName);
		driver.findElement(buttonSearch).click();
	   driver.findElement(phoneLink).click();
	   
	
	}
	
	
	public void retrvieingDeatilsOfProduct(String manufact,String dimesion,String asin) {
		 manufact=driver.findElement(labelManfact).getText();
		 dimesion= driver.findElement(labelDimen).getText();
		 asin= driver.findElement(labelASIN).getText();
	}
	
	
	public void  addingToCart(String addedCartLbl)
	{
		driver.findElement(addingCart).click();
		addedCartLbl=driver.findElement(labeladdedcart).getText();
	}
	  public void verifyingProductAddedInCart(String shoppingCart,String productName,String shoppingPageUrl) {
		  driver.findElement(cartContainer).click();
		  shoppingCart=  driver.findElement(cartHeader).getText();
		   productName= driver.findElement(productAddedToCart).getText();
		   shoppingPageUrl=driver.getCurrentUrl();
		  
	  }
	
	public void multiWindows() {
		String mainWindow = driver.getWindowHandle();
		Set<String> multiple = driver.getWindowHandles();
		for (String windowid : multiple)
			if (!windowid.equalsIgnoreCase(mainWindow)) {
				driver.switchTo().window(windowid);
				System.out.println(driver.switchTo().window(windowid).getTitle());
			}

	}

}
