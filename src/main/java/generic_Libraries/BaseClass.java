package generic_Libraries;

import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_package.BaseClassPage;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public WebDriver d;
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException, IOException {
		
		String browser = UtilityMethod.getProperty("Browser");
		
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
	        ChromeOptions op = new ChromeOptions();
	        op.setAcceptInsecureCerts(true);
			d = new ChromeDriver(op);
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			d = new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("FireFox")) {
			d = new FirefoxDriver();
		}
		
		d.manage().window().maximize();
		d.get(UtilityMethod.getProperty("URL"));
		
		/*
		 * BaseClassPage bccp = new BaseClassPage(d); bccp.getDetailButton().click();
		 * bccp.getProceedLink().click();
		 */

	}

	@BeforeMethod
	public void loginMethod() throws InterruptedException, IOException {

		BaseClassPage bccp = new BaseClassPage(d);
		bccp.getUserID().sendKeys(UtilityMethod.getProperty("UN"));
		bccp.getPassword().sendKeys(UtilityMethod.getProperty("PWD"));
		bccp.getLoginButton().click();
		Thread.sleep(2000);
		try {
	        Alert alert = d.switchTo().alert();
	        System.out.println("Alert text: " + alert.getText());
	        alert.accept(); // or alert.dismiss()
	    } catch (NoAlertPresentException e) {
	        // No alert appeared, continue
	        System.out.println("No alert present.");
	    }
	}


	//@AfterMethod
	public void logoutMethod() {

		BaseClassPage bccp = new BaseClassPage(d);
		bccp.getLogout().click();
		Alert alert = d.switchTo().alert();
        alert.accept();
	}
	
	//@AfterClass
	public void closeBrowser() {

		d.quit();
		
	}

}
