package Indian_Bank;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.ModuleMappingPage;

public class ModuleMapping extends BaseClass {

	@Test
	public void ModuleMappingTest() throws IOException {

		ModuleMappingPage mmp = new ModuleMappingPage(d);

		mmp.getMaster().click();
		mmp.getAuditee().click();
		mmp.getModuleMappingMaster().click();
		mmp.getSearchBox().sendKeys(UtilityMethod.getProperty("BranchCode"));
		List<WebElement> branLists = mmp.getBranList();

		for (WebElement branList : branLists) {

			if (branList.getText().contains(UtilityMethod.getProperty("BranchCode"))) {
				branList.click();
				break;
			}

		}

		// WAIT for table rows to load fully
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(15));
		List<WebElement> modLists = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tr[contains(@class,'Rows')]")));

		boolean clicked = false;

		for (WebElement modList : modLists) {

			if (modList.getText().contains("Risk Based Internal Audit")) {

				// Re-locate checkbox fresh (avoid stale element)
				WebElement checkBox = mmp.getCheckBox(modList);
				

				// Scroll into view
				((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", checkBox);

				// Wait until clickable
				wait.until(ExpectedConditions.elementToBeClickable(checkBox));

				try {
					// Try normal click
					checkBox.click();
				} catch (Exception e) {
					// Fallback to JS click
					((JavascriptExecutor) d).executeScript("arguments[0].click();", checkBox);
				}

				clicked = true;
				break;
			}
		}

		if (!clicked) {
			System.out.println("❌ Checkbox row not found!");
		} else {
			System.out.println("✔ Checkbox clicked successfully!");
		}
		
		WebElement Save = mmp.getSaveButton();
		((JavascriptExecutor) d).executeScript("arguments[0].click();", Save);

	}

}
