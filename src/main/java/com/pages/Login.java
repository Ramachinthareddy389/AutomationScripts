/**
 * 
 */
package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author rama.chinthareddy
 *
 */
public class Login {

	
	WebDriver driver;

	By username=By.id("ap_email");
	By next =By.id("continue");
	By pass=By.id("ap_password");
	By signin=By.id("signInSubmit");
	By account=By.id("nav-link-accountList-nav-line-1");
	By presignin=By.cssSelector("#nav-flyout-ya-signin");
	
	public Login(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void preCondition() {
		driver.findElement(account).click();
		//driver.findElement(presignin).click();
		
	}
	public void typeUserName(String user)
	{
		driver.findElement(username).sendKeys(user);
	}
	
	public void clickContinue()
	{
		driver.findElement(next).click();
	}
	
	
	public void typePassword(String password)
	{
		driver.findElement(pass).sendKeys(password);
	}
	
	public void LoginButton() {
		driver.findElement(signin).click();
	}
	
	
}
