package Indian_Bank;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.AuditCommencementPage;

public class AuditCommencement extends BaseClass{
	
	@Test
	public void Commencement() throws IOException {
		
		AuditCommencementPage acp=new AuditCommencementPage(d);
		
		//Branch Search
		acp.getBranchSearch().sendKeys(UtilityMethod.getProperty("BranchCode"));
		
		//Branch Selection
		List<WebElement> rows = acp.getBranchRow();
		
		for(WebElement row: rows) {
			if(row.getText().contains(UtilityMethod.getProperty("BranchCode"))) {
				WebElement BranchCode = acp.getBranchSelection(row);
				((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", BranchCode);
				BranchCode.click();
				
			}
		}
		//Audit
		acp.getAudit().click();
		
		//Audit Execution
		acp.getAuditExecution().click();
		
		//Audit Commencement
		acp.getAuditCommencement().click();
		
		//Save Button
		acp.getSave().click();
		
	}

}
