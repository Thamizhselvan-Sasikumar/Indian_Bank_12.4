package Indian_Bank;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.AuditObservationPage;

public class JLScoreSheet extends BaseClass {

	@Test
	public void JLScoreSheetTest() throws Exception {

		System.out.println("JL Score Sheet");

		AuditObservationPage aop = new AuditObservationPage(d);
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));

		// Branch Search
		aop.getBranchSearch().sendKeys(UtilityMethod.getProperty("BranchCode"));

		// Branch Selection
		clickBranchCode(UtilityMethod.getProperty("BranchCode"));

		// Audit
		wait.until(ExpectedConditions.visibilityOf(aop.getAudit()));
		aop.getAudit().click();

		System.out.println("Clicked Audit");

		// JL Score Sheet Menu
		clickLeftMenu("JL Score Sheet");

		// JL Score sheet Checklist Function
		List<WebElement> StausDropdown = d.findElements(By.xpath("//select[contains(@id,'cmmds')]"));
		List<WebElement> RemarksTextBox = d.findElements(By.xpath("//textarea[contains(@id,'textarea')]"));
		List<WebElement> RiskDropdown = d.findElements(By.xpath("//select[contains(@id,'risk')]"));

		int limit = Integer.parseInt(UtilityMethod.getProperty("ChecklistLimitJL"));

		for (int i = 0; i < limit; i++) {
			// Thread.sleep(2000);
			WebElement sd = StausDropdown.get(i);
			wait.until(ExpectedConditions.visibilityOfAllElements(sd));
			Select s1 = new Select(sd);
			s1.selectByVisibleText(UtilityMethod.getProperty("StatusJL"));
			// Thread.sleep(2000);
			WebElement rtb = RemarksTextBox.get(i);
			rtb.sendKeys(UtilityMethod.getProperty("CommentsJL") + " - " + (i + 1));
			// Thread.sleep(2000);
			WebElement rd = RiskDropdown.get(i);
			wait.until(ExpectedConditions.visibilityOfAllElements(rd));
			Select s2 = new Select(rd);
			s2.selectByVisibleText(UtilityMethod.getProperty("RiskJL"));
		}

		// Upload file for 15% of JL Verification Certificate Upload
		d.findElement(By.xpath("//a[@id='uploadbtn']")).click();

		//d.findElement(By.id("filetext")).click();
		uploadFileTest();

	}

}
