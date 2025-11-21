package Indian_Bank;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.AuditObservationPage;
import pom_package.ExecutiveSummaryPage;

public class ExecutiveSummary extends BaseClass {
	
	@Test
	public void ExecutiveSummaryTest() throws IOException {
		
		AuditObservationPage aop = new AuditObservationPage(d);
		ExecutiveSummaryPage esp=new ExecutiveSummaryPage(d);

		// Branch Search
		aop.getBranchSearch().sendKeys(UtilityMethod.getProperty("BranchCode"));

		// Branch Selection
		clickBranchCode(UtilityMethod.getProperty("BranchCode"));

		System.out.println("Branch selected");

		// Audit
		aop.getAudit().click();
		
		//Executive summary Datasheet
		WebElement menu = esp.getExecutiveSummaryMenu();
		((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", menu);
		esp.getExecutiveSummaryMenu().click();
		
		esp.getExecutiveSummaryDataSheet().click();
		
		WebElement frame = esp.getIframe();
		
		d.switchTo().frame(frame);
		
		List<WebElement> textBoxes = esp.getTextField();
		
		for(WebElement textBox: textBoxes) {
			
			textBox.sendKeys("Executive Summary Datasheet Comments");
		}
		
		esp.getSave().click();
		
	}

}
