package generic_Libraries;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_package.AuditObservationPage;
import pom_package.BaseClassPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	public WebDriverWait wait;

	// =====================================================================
	// CLEAR COOKIES + CACHE + STORAGE
	// =====================================================================
	public void clearBrowserCookies() {
		try {
			// Cookies
			d.manage().deleteAllCookies();

			// LocalStorage + SessionStorage
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("window.localStorage.clear();");
			js.executeScript("window.sessionStorage.clear();");

			d.navigate().refresh();

		} catch (Exception e) {
			System.out.println("Error clearing browser cache: " + e.getMessage());
		}
	}

	// =====================================================================
	// BROWSER LAUNCH
	// =====================================================================
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

		clearBrowserCookies();
	}

	// =====================================================================
	// LOGIN METHOD
	// =====================================================================
	@BeforeMethod
	@Parameters("role")
	public void loginMethod(String role) throws InterruptedException, IOException {

		BaseClassPage bccp = new BaseClassPage(d);
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));

		String username = "";
		String password = "";

		switch (role.toUpperCase()) {
		case "NCS":
			username = UtilityMethod.getProperty("SuperAdmin");
			password = UtilityMethod.getProperty("SuperAdmiPassword");
			break;

		case "HO":
			username = UtilityMethod.getProperty("HOUser");
			password = UtilityMethod.getProperty("HOUserPassword");
			break;

		case "AUDITOR":
			username = UtilityMethod.getProperty("AuditorUser");
			password = UtilityMethod.getProperty("AuditorPassword");
			break;

		default:
			username = UtilityMethod.getProperty("Default");
			password = UtilityMethod.getProperty("DefaultPassword");
			break;
		}

		bccp.getUserID().sendKeys(username);
		bccp.getPassword().sendKeys(password);
		bccp.getLoginButton().click();
		Thread.sleep(2000);

		try {
			Alert alert = d.switchTo().alert();
			System.out.println("Alert Text: " + alert.getText());
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("No alert shown during login.");
		}

		Thread.sleep(2000);

		// MODULE SELECTION
		try {
			List<WebElement> modules = wait.until(ExpectedConditions
					.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='cls_ms_module_name_wrap']//p")));

			for (WebElement m : modules) {
				if (m.getText().equalsIgnoreCase(UtilityMethod.getProperty("Module"))) {
					wait.until(ExpectedConditions.elementToBeClickable(m)).click();
					System.out.println("Clicked module: " + m.getText());
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Module selection skipped: " + e.getMessage());
		}
	}

	// =====================================================================
	// STABLE BRANCH CODE CLICK METHOD (✨ KEY FEATURE)
	// =====================================================================
	public void clickBranchCode(String branchCode) {

		AuditObservationPage aop = new AuditObservationPage(d);

		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(15));

		for (int retry = 0; retry < 3; retry++) {
			try {

				List<WebElement> rows = wait.until(
						ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tr[contains(@class,'Rows')]")));

				for (WebElement row : rows) {
					if (row.getText().contains(branchCode)) {

						WebElement branchElement = aop.getBranchSelection(row);

						wait.until(ExpectedConditions.visibilityOf(branchElement));
						wait.until(ExpectedConditions.elementToBeClickable(branchElement));

						// Scroll
						((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", branchElement);
						Thread.sleep(300);

						try {
							branchElement.click();
						} catch (Exception e) {
							((JavascriptExecutor) d).executeScript("arguments[0].click();", branchElement);
						}

						System.out.println("Clicked Branch Code: " + branchCode);
						return;
					}
				}

				System.out.println("Branch not found in this retry...");

			} catch (Exception e) {
				System.out.println("Retry " + retry + " failed: " + e.getMessage());
			}
		}

		throw new RuntimeException("Branch Code NOT CLICKED even after 3 retries: " + branchCode);
	}

	// =====================================================================
	// LOGOUT
	// =====================================================================
	//@AfterMethod
	public void logoutMethod() {
		try {
			BaseClassPage bccp = new BaseClassPage(d);
			wait.until(ExpectedConditions.visibilityOf(bccp.getLogout()));
			bccp.getLogout().click();

			try {
				Alert alert = d.switchTo().alert();
				alert.accept();
			} catch (NoAlertPresentException e) {
			}

		} catch (Exception e) {
			System.out.println("Logout not executed: " + e.getMessage());
		}
	}

	// =====================================================================
	// CLOSE BROWSER
	// =====================================================================
	//@AfterClass
	public void closeBrowser() {
		d.quit();
	}
}