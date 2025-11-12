package generic_Libraries;

import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_package.BaseClassPage;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public WebDriver d;

	@BeforeClass
	public void launchBrowser() throws InterruptedException, IOException {

		String browser = UtilityMethod.getProperty("Browser");

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions op = new ChromeOptions();
			op.setAcceptInsecureCerts(true);
			d = new ChromeDriver(op);
		} else if (browser.equalsIgnoreCase("Edge")) {
			EdgeOptions op = new EdgeOptions();
			op.setAcceptInsecureCerts(true);
			d = new EdgeDriver(op);
		} else if (browser.equalsIgnoreCase("FireFox")) {
			FirefoxOptions op = new FirefoxOptions();
			op.setAcceptInsecureCerts(true);
			d = new FirefoxDriver(op);
		}

		d.manage().window().maximize();
		d.get(UtilityMethod.getProperty("URL"));

	}

	@BeforeMethod
	public void loginMethod() throws InterruptedException, IOException {

		BaseClassPage bccp = new BaseClassPage(d);
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));

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

		Thread.sleep(2000);
		
		try {
		    // Wait for all available modules to load
		    List<WebElement> Module = wait.until(
		        ExpectedConditions.presenceOfAllElementsLocatedBy(
		            By.xpath("//div[@class='cls_ms_module_name_wrap']//p")
		        )
		    );

		    boolean moduleFound = false;

		    for (WebElement m : Module) {
		        System.out.println("Found Module: " + m.getText());

		        if (m.getText().equalsIgnoreCase(UtilityMethod.getProperty("Module"))) {
		            wait.until(ExpectedConditions.elementToBeClickable(m)).click();
		            System.out.println("Clicked on module: " + m.getText());
		            moduleFound = true;
		            break;
		        }
		    }

		    if (!moduleFound) {
		        System.out.println("Module not available. Skipping module selection.");
		    }

		} catch (NoSuchElementException e) {
		    System.out.println("No module elements found. Skipping module selection.");
		} catch (ElementClickInterceptedException e) {
		    System.out.println("Unable to click module (overlay or blocked). Skipping module selection.");
		} catch (Exception e) {
		    System.out.println("Unexpected error during module selection: " + e.getMessage());
		}

	}

	// @AfterMethod
	public void logoutMethod() {

		BaseClassPage bccp = new BaseClassPage(d);
		bccp.getLogout().click();
		Alert alert = d.switchTo().alert();
		alert.accept();
	}

	// @AfterClass
	public void closeBrowser() {

		d.quit();

	}

}
