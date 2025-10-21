package generic_Libraries;

import org.testng.annotations.BeforeMethod;

import pom_package.BaseClassPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public WebDriver d;
	
	

	@BeforeClass
	public void launchBrowser() throws InterruptedException {
		
		
		
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://192.9.200.27:2322/IB_12_4/login.htm");
		
		BaseClassPage bccp = new BaseClassPage(d);
		bccp.getDetailButton().click();
		bccp.getProceedLink().click();

	}

	@BeforeMethod
	public void loginMethod() throws InterruptedException {

		BaseClassPage bccp = new BaseClassPage(d);
		bccp.getUserID().sendKeys("NCSTS");
		bccp.getPassword().sendKeys("1234");
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
