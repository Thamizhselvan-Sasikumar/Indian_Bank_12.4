package Indian_Bank;

import java.io.IOException;

import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.AuditObservationAuthPage;
import pom_package.AuditObservationPage;

public class AuditObservationAuth extends BaseClass {

	@Test
	public void ObservationAuth() throws IOException {

		AuditObservationPage aop = new AuditObservationPage(d);
		AuditObservationAuthPage aoa = new AuditObservationAuthPage(d);

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
		 * BranchCode.click(); } }
		 */
		
		// Audit
		aop.getAudit().click();

		// Audit Execution
		aop.getAuditExecution().click();

		// Audit Observation Authorization
		aoa.getAuditObserAuth().click();

		// Selection All Checklist
		aoa.getSelectAllChecklist().click();

		// Checklist Selection one by one

		/*
		 * List<WebElement> checkboxs = aoa.getSelectCheckbox(); for (WebElement
		 * checkbox : checkboxs) { for (int i = 0; i < 1; i++) { ((JavascriptExecutor)
		 * d).executeScript("arguments[0].scrollIntoView(true);", checkbox);
		 * checkbox.click(); } break; }
		 */

		// Save
		aoa.getSaveButton().click();

	}

}
