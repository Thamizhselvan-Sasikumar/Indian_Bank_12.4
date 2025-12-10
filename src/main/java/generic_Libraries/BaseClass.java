package generic_Libraries;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_package.AuditObservationPage;
import pom_package.BaseClassPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

	
	public void safeClick(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOf(element));
	    wait.until(ExpectedConditions.elementToBeClickable(element));

	    try {
	        element.click();
	    } catch (Exception e) {
	        ((JavascriptExecutor) d).executeScript("arguments[0].click();", element);
	    }
	}
	
	
	public void handleUnexpectedAlert() {
	    try {
	        Alert alert = d.switchTo().alert();
	        System.out.println("Alert handled: " + alert.getText());
	        alert.accept();
	    } catch (Exception e) {
	        // No alert
	    }
	}
	
	public void clickSaveButton(WebElement saveBtn) {
	    WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(15));

	    try {
	        // Wait for button to be clickable
	        wait.until(ExpectedConditions.elementToBeClickable(saveBtn));

	        // Scroll into view
	        ((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
	        Thread.sleep(300);

	        // Try normal click
	        try {
	            saveBtn.click();
	        } catch (Exception e) {
	            // Fallback JS click
	            ((JavascriptExecutor) d).executeScript("arguments[0].click();", saveBtn);
	        }

	        // Handle alert if triggered after save
	        try {
	            Alert a = d.switchTo().alert();
	            System.out.println("Save Alert: " + a.getText());
	            a.accept();
	        } catch (Exception e) {}

	        // Wait for page load / refresh
	        Thread.sleep(1500);

	    } catch (Exception e) {
	        System.out.println("SAVE button not clicked: " + e.getMessage());
	    }
	}
	
	public void clickLeftMenu(String menuName) {
	    WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(15));

	    for (int retry = 0; retry < 4; retry++) {
	        try {
	            // Find menu item
	            WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//a[normalize-space()='" + menuName + "']")));

	            // Scroll into center (stable scroll)
	            ((JavascriptExecutor) d).executeScript(
	                    "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", menu);

	            Thread.sleep(400); // let UI settle

	            try {
	                wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
	            } catch (Exception e) {
	                ((JavascriptExecutor) d).executeScript("arguments[0].click();", menu);
	            }

	            // Small pause to confirm correct navigation
	            Thread.sleep(600);

	            System.out.println("Clicked Menu Successfully: " + menuName);
	            return;

	        } catch (Exception e) {
	            System.out.println("Retry Menu Click [" + retry + "] for: " + menuName);
	        }
	    }

	    throw new RuntimeException("Menu NOT CLICKED even after retries: " + menuName);
	}
	
	
	//File Upload
	public void uploadThroughFileExplorer(String filePath) throws Exception {

	    // Copy file path to clipboard
	    StringSelection ss = new StringSelection(filePath);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

	    // Create Robot instance
	    Robot robot = new Robot();
	    robot.setAutoDelay(500);

	    // Press CTRL + V (paste the file path into the File Explorer window)
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);

	    robot.setAutoDelay(500);

	    // Press ENTER to confirm file selection
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void uploadFileTest() throws Exception {

	    // Click the upload icon or button that opens File Explorer
	    d.findElement(By.xpath("//input[contains(@id,'filetext')]")).click();

	    Thread.sleep(1500); // wait for File Explorer to appear

	    // Call the Robot upload method
	    uploadThroughFileExplorer("E:\\Thamizh\\Upload File\\JL Score Sheet.pdf");

	    System.out.println("File uploaded successfully!");
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