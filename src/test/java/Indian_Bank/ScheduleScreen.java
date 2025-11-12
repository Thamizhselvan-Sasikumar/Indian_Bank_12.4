package Indian_Bank;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.ScheduleScreenPage;

public class ScheduleScreen extends BaseClass {
	@Test
	public void schedule() throws InterruptedException, IOException {

		ScheduleScreenPage ssp = new ScheduleScreenPage(d);


		ssp.getAudit().click();
		ssp.getPlanSch().click();
		ssp.getSchedule().click();

		WebElement AttachedTo = ssp.getAttachedTO();

		Select s1 = new Select(AttachedTo);
		s1.selectByValue(UtilityMethod.getProperty("SchZone"));

		ssp.getSearchBox().sendKeys(UtilityMethod.getProperty("BranchCode"));

		Thread.sleep(2000);
		List<WebElement> BranchCode = ssp.getBranchCode();

		for (WebElement bc : BranchCode) {

			String bcode = bc.getText();

			System.out.println(bcode);

			if (bc.getText().equalsIgnoreCase(bcode)) {
				bc.click();
				break;
			}

		}

		WebElement generate = ssp.getGenerate();
		generate.click();

		List<WebElement> rows = ssp.getRows();

		// Check Box
		for (WebElement row : rows) {
			if (row.getText().contains(UtilityMethod.getProperty("BranchCode"))) {
				WebElement CheckBox =ssp.getCheckBox(row);
				((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", CheckBox);
				CheckBox.click();
			}
		}

		// Team Lead Icon
		for (WebElement row : rows) {
			if (row.getText().contains(UtilityMethod.getProperty("BranchCode"))) {
				WebElement TeamLeadIcon =ssp.getTLIcon(row);
				((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", TeamLeadIcon);
				TeamLeadIcon.click();
			}
		}

		// Team Lead selection
		Thread.sleep(2000);
		List<WebElement> TeamLeads = ssp.getTLList();

		for (WebElement TeamLead : TeamLeads) {
			if (TeamLead.getText().contains(UtilityMethod.getProperty("TL"))) {
				WebElement TeamLeadSelection = ssp.getTLRadioButton(TeamLead);
				((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", TeamLeadSelection);
				TeamLeadSelection.click();
			}
		}

		try {
			Alert alert = d.switchTo().alert();
			System.out.println("Alert text: " + alert.getText());
			alert.accept(); // or alert.dismiss()
		} catch (NoAlertPresentException e) {
			// No alert appeared, continue
			System.out.println("No alert present in Team Lead Selection.");
		}

		// From Date
		Thread.sleep(3000);
		for (WebElement row : rows) {
			if (row.getText().contains(UtilityMethod.getProperty("BranchCode"))) {
				WebElement FromDate = ssp.getFromDate(row);
				((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", FromDate);
				FromDate.click();
			}
		}

		Actions a = new Actions(d);
		a.sendKeys(Keys.ENTER).perform();

		ssp.getSave().click();

	}

}
