package Indian_Bank;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.PlanScreenPage;

public class PlanScreen extends BaseClass {

	@Test
	public void plan() throws InterruptedException, IOException {

		PlanScreenPage psp = new PlanScreenPage(d);


		psp.getAudit().click();
		psp.getPlanSch().click();
		psp.getPlan().click();

		WebElement AttachedTo = psp.getAttachedTO();

		Select s1 = new Select(AttachedTo);
		s1.selectByVisibleText(UtilityMethod.getProperty("AttachedTo"));

		WebElement PlanType = psp.getPlanType();

		Select s2 = new Select(PlanType);
		s2.selectByVisibleText(UtilityMethod.getProperty("PlanType"));

		WebElement Period = psp.getPeriod();

		if (Period.isEnabled()) {
			Select s3 = new Select(Period);
			s3.selectByVisibleText(UtilityMethod.getProperty("Period"));
			System.out.println("Period dropdown enabled — value selected.");
		} else {
			System.out.println("Period dropdown is disabled — skipping selection.");
		}

		WebElement FinancialYear = psp.getFinYear();

		Select s4 = new Select(FinancialYear);
		s4.selectByVisibleText(UtilityMethod.getProperty("FinYear"));

		psp.getSearchBox().sendKeys(UtilityMethod.getProperty("BranchCode"));

		Thread.sleep(2000);
		List<WebElement> BranchCode = psp.getBranchCode();

		for (WebElement bc : BranchCode) {

			String bcode = bc.getText();

			System.out.println(bcode);

			if (bc.getText().equalsIgnoreCase(bcode)) {
				bc.click();
				break;
			}

		}

		
		List<WebElement> rows = psp.getRowList();
		
		for(WebElement row: rows) {
			if(row.getText().contains(UtilityMethod.getProperty("BranchCode"))) {
				WebElement CheckBox = psp.getCheckBox(row);
				((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", CheckBox);
				CheckBox.click();
			}
		}
		
		for(WebElement row: rows) {
			if(row.getText().contains(UtilityMethod.getProperty("BranchCode"))) {
				WebElement Text =psp.getText(row);
				((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", Text);
				Text.clear();
				Text.sendKeys(UtilityMethod.getProperty("ActMan"));
			}
		}
		
  
		psp.getSave().click();

	} 
}
