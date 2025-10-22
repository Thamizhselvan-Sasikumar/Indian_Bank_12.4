package Indian_Bank;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.BranchCreationPage;

public class BranchCreation extends BaseClass {

	@Test
	public void branchCreation() throws InterruptedException, IOException {

		BranchCreationPage bcp = new BranchCreationPage(d);

		// Master Menu
		bcp.getMasterMenu().click();

		// Auditee Menu
		bcp.getAuditeeMenu().click();

		// Branch Master Menu
		bcp.getBranchMasterMenu().click();

		// Add Button
		bcp.getAddButton().click();

		// Branch Code
		bcp.getBranchCode().sendKeys(UtilityMethod.getProperty("BranchCode"));

		// Branch Name
		bcp.getBranchName().sendKeys(UtilityMethod.getProperty("BranchName"));

		// Branch Size

		WebElement branchSize = bcp.getBranchSize();
		Select s1 = new Select(branchSize);
		s1.selectByVisibleText(UtilityMethod.getProperty("BranchSize"));

		// Main Branch
		WebElement mainBranch = bcp.getMainBranch();
		Select s2 = new Select(mainBranch);
		s2.selectByVisibleText(UtilityMethod.getProperty("MainBranch"));

		// Address
		bcp.getAddress().sendKeys(UtilityMethod.getProperty("Address"));

		// BSR Code
		bcp.getBSRCode().sendKeys(UtilityMethod.getProperty("BSRCode"));

		// Open Date
		bcp.getOpenDate().click();

		// Year
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
		WebElement year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@title='Change the year']")));


		Select s7 = new Select(year);
		s7.selectByVisibleText(UtilityMethod.getProperty("Year"));
		//Thread.sleep(2000);

		// Month
		WebDriverWait wait1 = new WebDriverWait(d, Duration.ofSeconds(10));
		WebElement month = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@title='Change the month']")));

		Select s8 = new Select(month);
		s8.selectByVisibleText(UtilityMethod.getProperty("Month"));
		//Thread.sleep(2000);

		// Date
		List<WebElement> days = d.findElements(By.xpath("//div[@class='datepick-month']/table/tbody//td"));

		for (WebElement day : days) {
			if (day.getText().equalsIgnoreCase(UtilityMethod.getProperty("Date"))) {
				day.click();
				break;
			}
		}

		//Thread.sleep(2000);

		// Branch Type
		WebElement branchType = bcp.getBranchType();
		Select s3 = new Select(branchType);
		s3.selectByVisibleText(UtilityMethod.getProperty("BranchType"));

		// RBIA Type
		WebElement rbiaType = bcp.getRBIAType();
		Select s4 = new Select(rbiaType);
		s4.selectByVisibleText(UtilityMethod.getProperty("RBIAType"));

		// City
		bcp.getCity().sendKeys(UtilityMethod.getProperty("City"));

		// Pincode
		bcp.getPincode().sendKeys(UtilityMethod.getProperty("Pincode"));

		// State
		bcp.getStateSearch().click();

		List<WebElement> state = d.findElements(By.xpath("//div[@class='popupcontent p-b-b']//li"));

		for (WebElement st : state) {
			if (st.getText().equalsIgnoreCase(UtilityMethod.getProperty("State"))) {
				st.click();
				break;
			}
		}

		Thread.sleep(2000);

		// District
		bcp.getDistrictSearch().click();

		List<WebElement> district = d.findElements(By.xpath("//div[@class='popupcontent p-b-b']//li"));

		for (WebElement dt : district) {
			if (dt.getText().equalsIgnoreCase(UtilityMethod.getProperty("District"))) {
				dt.click();
				break;
			}
		}

		Thread.sleep(2000);

		// Mobile number
		bcp.getMobileNumber().sendKeys(UtilityMethod.getProperty("MobileNumber"));

		// Email Address
		bcp.getEmailAddress().sendKeys(UtilityMethod.getProperty("Email"));

		// Forex
		WebElement foreignExchange = bcp.getForex();
		Select s5 = new Select(foreignExchange);
		s5.selectByVisibleText(UtilityMethod.getProperty("Forex"));

		// From and To Time
		bcp.getFromTime().sendKeys(UtilityMethod.getProperty("FromTime"));
		bcp.getToTime().sendKeys(UtilityMethod.getProperty("ToTime"));

		// Weekly Holidays
		WebElement weeklyHolidays = bcp.getWeeklyHoliday();
		Select s6 = new Select(weeklyHolidays);
		s6.selectByVisibleText(UtilityMethod.getProperty("WeeklyHoliday"));

		// Attached To
		bcp.getAttachedToSearch().click();

		List<WebElement> zone = d.findElements(By.xpath("//div[@class='popupcontent p-b-b']//li"));

		for (WebElement zo : zone) {
			if (zo.getText().equalsIgnoreCase(UtilityMethod.getProperty("AttachedTo"))) {
				zo.click();
				break;
			}
		}

		Thread.sleep(2000);

		// From Date
		bcp.getFromDate().click();
		Actions a = new Actions(d);
		a.sendKeys(Keys.ENTER).perform();

		// Branch Category
		bcp.getBranchCategorySearch().click();

		List<WebElement> branchcat = d.findElements(By.xpath("//div[@class='popupcontent p-b-b']//li"));

		for (WebElement bc : branchcat) {
			if (bc.getText().equalsIgnoreCase(UtilityMethod.getProperty("BranchCategory"))) {
				bc.click();
				break;
			}
		}

		Thread.sleep(2000);

		// Result
		System.out.println("Successfully Branch Created");

		// Save
		// d.findElement(By.xpath("//div[@id='editbranch']//button[text()='SAVE']")).click();

	}

}
