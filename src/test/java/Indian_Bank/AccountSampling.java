package Indian_Bank;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.AccountSamplingPage;

public class AccountSampling extends BaseClass {

	@Test
	public void Sampling() throws IOException {

		AccountSamplingPage asp = new AccountSamplingPage(d);

		// Branch Search
		asp.getBranchSearch().sendKeys(UtilityMethod.getProperty("BranchCode"));

		// Branch Selection
		List<WebElement> rows = asp.getBranchRow();

		for (WebElement row : rows) {
			if (row.getText().contains(UtilityMethod.getProperty("BranchCode"))) {
				WebElement BranchCode = asp.getBranchSelection(row);
				((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", BranchCode);
				BranchCode.click();

			}
		}
		// Audit
		asp.getAudit().click();

		// Audit Execution
		asp.getAuditExecution().click();
		
		// Account Sampling Menu
		asp.getAccountSamplingMenu().click();
		
		//Account Number
		asp.getAccountNumber().sendKeys(UtilityMethod.getProperty("AcctNo"));

		//Account Lists
		List<WebElement> accLists = asp.getAccountLists();

		//Account Selection
		for (WebElement accList : accLists) {
			
			//String acctno = accList.getText();
			
			System.out.println(accList.getText());

			if (accList.getText().contains(UtilityMethod.getProperty("AcctNo"))) {
				accList.click();
				break;
			}

		}
		
		//Save Button
		asp.getSave().click();

	}

}
