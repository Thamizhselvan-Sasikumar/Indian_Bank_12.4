package Indian_Bank;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.AuditObservationAuthPage;

public class AuditObservationAuth extends BaseClass {

	@Test
	public void ObservationAuth() throws IOException {

		AuditObservationAuthPage aoa = new AuditObservationAuthPage(d);

		// Branch Search
		aoa.getBranchSearch().sendKeys(UtilityMethod.getProperty("BranchCode"));

		// Branch Row
		List<WebElement> rows = aoa.getBranchRows();

		// Branch Selection
		for (WebElement row : rows) {
			if (row.getText().contains(UtilityMethod.getProperty("BranchCode"))) {
				WebElement BranchCode = aoa.getBranchRow(row);
				((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", BranchCode);
				BranchCode.click();
			}
		}

		// Audit
		aoa.getAuditee().click();

		// Audit Execution
		aoa.getAuditExecution().click();

		// Audit Observation Authorization
		aoa.getAuditObserAuth().click();

		// Selection All Checklist
		/* aoa.getSelectAllChecklist().click(); */

		// Checklist Selection one by one
		List<WebElement> checkboxs = aoa.getSelectCheckbox();
		for (WebElement checkbox : checkboxs) {
			for (int i = 0; i < 1; i++) {
				((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", checkbox);
				checkbox.click();
			}
			break;
		}

		// Save
		aoa.getSaveButton().click();

	}

}
