package Indian_Bank;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.ScheduleAuthPage;

public class ScheduleAuthScreen extends BaseClass {

	@Test(priority = 5)
	public void ScheduleAuth() throws InterruptedException, IOException {

		ScheduleAuthPage sap = new ScheduleAuthPage(d);

		sap.getAudit().click();
		sap.getPlanSch().click();
		sap.getScheduleAuth().click();

		WebElement AttachedTo = sap.getAttachedTO();

		Select s1 = new Select(AttachedTo);
		s1.selectByValue(UtilityMethod.getProperty("SchZone"));

		//Auditee Code/Name Search
		sap.getSearchBox().sendKeys(UtilityMethod.getProperty("BranchCode"));

		Thread.sleep(2000);
		List<WebElement> BranchCode = sap.getBranchCode();

		for (WebElement bc : BranchCode) {

			String bcode = bc.getText();

			System.out.println(bcode);

			if (bc.getText().equalsIgnoreCase(bcode)) {
				bc.click();
				break;
			}

		}
		
		// Check Box
		List<WebElement> rows = sap.getBranchCodeRows();
		
		for (WebElement row : rows) {
			if (row.getText().contains(UtilityMethod.getProperty("BranchCode"))) {
				WebElement CheckBox = sap.getCheckBox(row);
				((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", CheckBox);
				CheckBox.click();
			}
		}

		sap.getSave().click();

	}

}
