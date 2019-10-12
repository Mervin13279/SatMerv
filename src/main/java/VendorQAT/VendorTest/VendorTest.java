package VendorQAT.VendorTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class VendorTest {
     @Test
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"./drivers-20190824T024126Z-001/drivers/Geckodriver/Chromedriver/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//TO maximise the browser
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://acme-test.uipath.com/account/login");		//
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		WebElement ele = driver.findElementByXPath("//button[text()[normalize-space()='Vendors']]");
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();
		driver.findElement(By.linkText("Search for Vendor")).click();
		driver.findElement(By.id("vendorName")).sendKeys("Blue Lagoon");
		driver.findElement(By.id("buttonSearch")).click();
		WebElement ele1 = driver.findElementByXPath("(//table[@class='table']//td)[5]");
		String pth = ele1.getText();
		System.out.println(pth);
		driver.findElementByLinkText("Log Out").click();
		driver.close();
		
		
	    
		
	}

}


