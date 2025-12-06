package Indian_Bank;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.AuditObservationPage;
import pom_package.JLScoreSheetPage;

public class JLScoreSheet extends BaseClass {

	@Test
	public void JLScoreSheetTest() throws IOException, InterruptedException {

		AuditObservationPage aop = new AuditObservationPage(d);
		JLScoreSheetPage jsp = new JLScoreSheetPage(d);

		// Branch Search
		aop.getBranchSearch().sendKeys(UtilityMethod.getProperty("BranchCode"));

		// Branch Selection
		clickBranchCode(UtilityMethod.getProperty("BranchCode"));

		System.out.println("Branch selected");

		// Audit
		aop.getAudit().click();

		// JL Score Sheet
		WebElement menu = jsp.getJLScoreSheetMenu();
		((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", menu);
		jsp.getJLScoreSheetMenu().click();

		// Select Checklist DropDown
		List<WebElement> dropdown = d.findElements(By.xpath("//select[contains(@id,'cmmds')]"));
		// Select Text Box
		List<WebElement> TextBox = d.findElements(By.xpath("//textarea[contains(@id,'textarea')]"));

		//int limit = Integer.parseInt(UtilityMethod.getProperty("ChecklistLimitAcct"));

		for (int i = 0; i < 1; i++) {
			Thread.sleep(2000);
			WebElement dd = dropdown.get(i);
			wait.until(ExpectedConditions.visibilityOfAllElements(dd));
			Select s = new Select(dd);
			s.selectByValue("Y");
			d.findElement(By.xpath(""));
			aop.getChecklistSaveButton().click();
		}

		Thread.sleep(5000);

	}

}
