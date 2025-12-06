package Indian_Bank;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.AuditObservationPage;

public class AuditObservation extends BaseClass {

	/**
	 * Delete Script Delete from ETH_TB_AUDPT_AUDDTL where APAD_MODID = '1' and
	 * APAD_BRAN_CODE = '00027'; Delete FROM ETH_TB_AUDPT_TRHDR WHERE APTH_MODID IN
	 * ('1') and APTH_BRAN_CODE = '00027'; Delete from ETH_TB_AUDPT_PRODDTL where
	 * APPD_MODID = '1' and APPD_BRAN_CODE = '00027';
	 */

	@Test
	public void Observation() throws IOException, InterruptedException {

		AuditObservationPage aop = new AuditObservationPage(d);
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));

		// Branch Search
		aop.getBranchSearch().sendKeys(UtilityMethod.getProperty("BranchCode"));

		// Branch Selection
		clickBranchCode(UtilityMethod.getProperty("BranchCode"));

		/*
		 * List<WebElement> rows = aop.getBranchRow();
		 * 
		 * for (WebElement row : rows) { if
		 * (row.getText().contains(UtilityMethod.getProperty("BranchCode"))) {
		 * WebElement BranchCode = aop.getBranchSelection(row); ((JavascriptExecutor)
		 * d).executeScript("arguments[0].scrollIntoView(true);", BranchCode);
		 * BranchCode.click(); break; }
		 * 
		 * }
		 */
		
		System.out.println("Branch selected");

		// Audit
		wait.until(ExpectedConditions.visibilityOf(aop.getAudit()));
		aop.getAudit().click();

		// Audit Execution
		aop.getAuditExecution().click();

		// Audit Observation
		aop.getAuditObservationMenu().click();

		// Customer Search Icon
		aop.getCustomerSearchIcon().click();

		// Customer Search Box
		aop.getCustomerSearchBox().sendKeys(UtilityMethod.getProperty("CustId"));

		// Customer Lists
		List<WebElement> custLists = aop.getCustomerLists();

		// Customer Selection
		for (WebElement custList : custLists) {
			if (custList.getText().contains(UtilityMethod.getProperty("CustId"))) {
				custList.click();
				break;
			}

		}

		// Customer row Selection
		List<WebElement> custRows = aop.getCustomerRows();

		// Customer CheckBox Selection
		for (WebElement custRow : custRows) {

			if (custRow.getText().contains(UtilityMethod.getProperty("AcctNo"))) {
				WebElement checkbox = aop.getCustomerCheckBox(custRow);
				((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", checkbox);
				checkbox.click();
			}
		}

		Thread.sleep(2000);

		// Select Checklist DropDown
		List<WebElement> dropdown = aop.getChecklistDropdown();

		int limit = Integer.parseInt(UtilityMethod.getProperty("ChecklistLimitAcct"));

		for (int i = 0; i < limit; i++) {
			Thread.sleep(2000);
			WebElement dd = dropdown.get(i);
			wait.until(ExpectedConditions.visibilityOfAllElements(dd));
			Select s = new Select(dd);
			s.selectByValue("N");
			aop.getAuditorComment().sendKeys(UtilityMethod.getProperty("CommentsAcct"));
			aop.getChecklistSaveButton().click();
		}

		// Overall Save
		clickSaveButton(aop.getOverallSaveButton());
		
		System.out.println("Account has been Saved");

		// General Banking
		WebElement AuditType = aop.getAuditType();

		Select s = new Select(AuditType);
		s.selectByValue("OR");

		// 1st and 2nd Level General Banking Product Code Selection
		for (int i = 0; i < 2; i++) {
			aop.getSelectAll().click();
			aop.getNextButton().click();
		}

		// Select Checklist DropDown
		List<WebElement> dropdown_GB = aop.getChecklistDropdown();

		int limit_GB = Integer.parseInt(UtilityMethod.getProperty("ChecklistLimitGB"));

		for (int i = 0; i < limit_GB; i++) {
			Thread.sleep(2000);
			WebElement dd_GB = dropdown_GB.get(i);
			wait.until(ExpectedConditions.visibilityOfAllElements(dd_GB));
			Select s1 = new Select(dd_GB);
			s1.selectByValue("N");
			aop.getAuditorComment().sendKeys(UtilityMethod.getProperty("CommentsGB"));
			aop.getChecklistSaveButton().click();
		}

		// Mandatory Checklist
		Thread.sleep(2000);
		WebElement MandatoryChecklist = aop.getMandatoryChecklist();
		((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", MandatoryChecklist);
		Select s2 = new Select(MandatoryChecklist);
		s2.selectByValue("N");
		aop.getAuditorComment().sendKeys(UtilityMethod.getProperty("CommentsGB"));
		aop.getChecklistSaveButton().click();

		// General Banking Save Button
		clickSaveButton(aop.getOverallSaveButton());
		
		System.out.println("General Banking Saved");

		// Zero Tolerance Section
		// Audit
		wait.until(ExpectedConditions.visibilityOfAllElements(aop.getAudit()));
		aop.getAudit().click();

		// Audit Execution
		aop.getAuditExecution().click();

		// Audit Observation
		aop.getAuditObservationMenu().click();

		WebElement AuditType_ZT = aop.getAuditType();
		Select s1 = new Select(AuditType_ZT);
		s1.selectByValue("ZT");

		// WAIT for page/table to load fully
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table")));

		// Scroll Select All into view
		((JavascriptExecutor)d).executeScript("arguments[0].scrollIntoView(true);", aop.getSelectAll());

		// SAFE CLICK (never fails)
		safeClick(aop.getSelectAll());

		// WAIT for "Next" to become clickable
		wait.until(ExpectedConditions.elementToBeClickable(aop.getNextButton()));
		((JavascriptExecutor)d).executeScript("arguments[0].scrollIntoView(true);", aop.getNextButton());

		// SAFE CLICK for Next
		safeClick(aop.getNextButton());

		// Select Checklist DropDown
		List<WebElement> dropdown_ZT = aop.getChecklistDropdown();

		int limit_ZT = Integer.parseInt(UtilityMethod.getProperty("ChecklistLimitZT"));

		for (int i = 0; i < limit_ZT; i++) {
			Thread.sleep(2000);
			WebElement dd_ZT = dropdown_ZT.get(i);
			wait.until(ExpectedConditions.visibilityOfAllElements(dd_ZT));
			Select s3 = new Select(dd_ZT);
			s3.selectByValue("N");
			Alert a = d.switchTo().alert();
			a.accept();
			aop.getAuditorComment().sendKeys(UtilityMethod.getProperty("CommentsZT"));
			aop.getChecklistSaveButton().click();
		}

		// Zero Tolerance Save Button
		clickSaveButton(aop.getOverallSaveButton());

	}

}
