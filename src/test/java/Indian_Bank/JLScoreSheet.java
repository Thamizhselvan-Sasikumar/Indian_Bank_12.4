package Indian_Bank;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.AuditObservationPage;
import pom_package.JLScoreSheetPage;

public class JLScoreSheet extends BaseClass {

	@Test
	public void JLScoreSheetTest() throws IOException, InterruptedException {

		AuditObservationPage aop = new AuditObservationPage(d);
		JLScoreSheetPage jsp=new JLScoreSheetPage(d);

		// Branch Search
		aop.getBranchSearch().sendKeys(UtilityMethod.getProperty("BranchCode"));

		// Branch Selection
		clickBranchCode(UtilityMethod.getProperty("BranchCode"));

		System.out.println("Branch selected");

		// Audit
		aop.getAudit().click();
		
		//JL Score Sheet
		WebElement menu = jsp.getJLScoreSheetMenu();
		((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", menu);
		jsp.getJLScoreSheetMenu().click();
		
		Thread.sleep(5000);
		
	}

}
