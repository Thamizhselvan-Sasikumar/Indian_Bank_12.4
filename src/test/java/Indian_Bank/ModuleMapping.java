package Indian_Bank;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.ModuleMappingPage;

public class ModuleMapping extends BaseClass {

	@Test(priority = 2)
	public void modulemapping() throws IOException, InterruptedException {

		ModuleMappingPage mmp = new ModuleMappingPage(d);

		// Master Menu
		mmp.getMasterMenu().click();

		// Auditee Menu
		mmp.getAuditeeMenu().click();

		// Module Mapping Master Menu
		mmp.getModuleMappingMasterMenu().click();

		// Branch Search Box
		mmp.getBranchSearch().sendKeys(UtilityMethod.getProperty("BranchCode"));

		// Branch List

		List<WebElement> branchList = mmp.getBranchList();

		for (WebElement bl : branchList) {

			bl.getText().equalsIgnoreCase(UtilityMethod.getProperty("BranchCode"));
			bl.click();
			break;
		}

		List<WebElement> rows = mmp.getModList();

		for (WebElement row : rows) {
			if (row.getText().contains(UtilityMethod.getProperty("Module"))) {
				WebElement CheckBox = mmp.getCheckBox(row);
				((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", CheckBox);
				CheckBox.click();
				break;
			}

		}

		WebElement Save = mmp.getSaveButton();
		((JavascriptExecutor) d).executeScript("arguments[0].click();", Save);
	}

}
