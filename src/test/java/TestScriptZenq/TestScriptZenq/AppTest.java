package TestScriptZenq.TestScriptZenq;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	String expectedText;

	@Test
	public void testing() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rama.chinthareddy\\eclipse-workspace\\TestScriptZenq\\Browser_Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone11phone 128gb");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String actualText = driver.getCurrentUrl();
		String expectedText = "https://www.amazon.in/s?k=iphone11phone+128gb&ref=nb_sb_noss";
		Assert.assertEquals(actualText, expectedText);
		driver.findElement(By.linkText("New Apple iPhone 11 (128GB) - White")).click();
		String mainWindow = driver.getWindowHandle();
		Set<String> multiple = driver.getWindowHandles();
		for (String windowid : multiple)
			if (!windowid.equalsIgnoreCase(mainWindow)) {
				driver.switchTo().window(windowid);
				System.out.println(driver.switchTo().window(windowid).getTitle());
			}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,10000)");
		String manufact = driver.findElement(By.cssSelector("#productDetails_techSpec_section_1>tbody>tr:nth-child(1)>td")).getText();
        expectedText = "Apple Inc. or Apple India Private Limited";
		Assert.assertEquals(manufact, expectedText);
        String dimesion = driver.findElement(By.cssSelector("#productDetails_techSpec_section_1>tbody>tr:nth-child(5)>td")).getText();
        expectedText = "16.85 x 9.33 x 2.9 cm; 138 Grams";
		Assert.assertEquals(dimesion, expectedText);
		String asin = driver.findElement(By.cssSelector("#productDetails_techSpec_section_1>tbody>tr:nth-child(6)>td")).getText();
		expectedText = "B08L89VM35";
		Assert.assertEquals(asin, expectedText);
		js.executeScript("scroll(0,0)");
		driver.findElement(By.id("add-to-cart-button")).click();
		String addedCart=driver.findElement(By.cssSelector("#huc-v2-order-row-confirm-text>h1")).getText();
		expectedText = "Added to Cart";
		Assert.assertEquals(addedCart, expectedText);
		driver.findElement(By.id("nav-cart-text-container")).click();
		String shoppingUrl=driver.getCurrentUrl();
		expectedText="https://www.amazon.in/gp/cart/view.html?ref_=nav_cart";
		Assert.assertEquals(shoppingUrl, expectedText);
	    String cardHeader=driver.findElement(By.cssSelector(".a-row.sc-cart-header.sc-compact-bottom>div>h1")).getText();
		expectedText="Shopping Cart";
		Assert.assertEquals(cardHeader, expectedText);
		if(cardHeader.equals(expectedText)) {
	    String phoneName=driver.findElement(By.linkText("New Apple iPhone 11 (128GB) - White")).getText();
		expectedText="New Apple iPhone 11 (128GB) - White";
		Assert.assertEquals(phoneName, expectedText);
		}
		driver.switchTo().window(mainWindow);
		driver.quit();
	}
	

}