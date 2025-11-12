package Indian_Bank;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.PlanAuthScreenPage;

public class PlanAuthScreen extends BaseClass{
	
  @Test
  public void planAuth() throws InterruptedException, IOException {
	  
	  PlanAuthScreenPage pas=new PlanAuthScreenPage(d);
	  
		  
		  pas.getAudit().click();
		  pas.getPlanSch().click();
		  pas.getPlanAuth().click();
		  
		  WebElement AttachedTo = pas.getAttachedTO();
		  
		  Select s1=new Select(AttachedTo);
		  s1.selectByVisibleText(UtilityMethod.getProperty("AttachedTo"));
		  
		  WebElement PlanType = pas.getPlanType();
		  
		  Select s2=new Select(PlanType);
		  s2.selectByVisibleText(UtilityMethod.getProperty("PlanType"));
		  
		  WebElement Period = pas.getPeriod();

		  if (Period.isEnabled()) {
		      Select s3 = new Select(Period);
		      s3.selectByVisibleText(UtilityMethod.getProperty("Period"));
		      System.out.println("Period dropdown enabled — value selected.");
		  } else {
		      System.out.println("Period dropdown is disabled — skipping selection.");
		  }
		  
		  WebElement FinancialYear = pas.getFinYear();
		  
		  Select s4=new Select(FinancialYear);
		  s4.selectByVisibleText(UtilityMethod.getProperty("FinYear"));
		  
		  
		  pas.getSearchBox().sendKeys(UtilityMethod.getProperty("BranchCode"));
		  
		  Thread.sleep(2000);
		  List<WebElement> BranchCode = pas.getBranchCode();
		  
		  for(WebElement bc: BranchCode) {
			  
			  String bcode = bc.getText();
			  
			  System.out.println(bcode);
			  
			  if(bc.getText().equalsIgnoreCase(bcode)) {
				  bc.click();
				  break;
			  }
			  
		  }
		  
		  List<WebElement> rows = pas.getRowList();
		  
			
			for(WebElement row: rows) {
				if(row.getText().contains(UtilityMethod.getProperty("BranchCode"))) {
					WebElement CheckBox = pas.getCheckBox(row);
					((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", CheckBox);
					CheckBox.click();
				}
			}
			
			
			for(WebElement row: rows) {
				if(row.getText().contains(UtilityMethod.getProperty("BranchCode"))) {
					WebElement Text =pas.getText(row);
					((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", Text);
					Text.clear();
					Text.sendKeys(UtilityMethod.getProperty("AuthMan"));
				}
			}
		  
			 
		pas.getSave().click();
  }
}
