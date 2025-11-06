package Indian_Bank;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.PlanScreenPage;

public class PlanScreen extends BaseClass{
	

  @Test
  public void plan() throws InterruptedException, IOException {
	  
	PlanScreenPage psp=new PlanScreenPage();
	  
	WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
	  
	Thread.sleep(3000);
	List<WebElement> Module = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	        By.xpath("//div[@class='cls_ms_module_name_wrap']//p")));
	  
	  
	  for(WebElement m: Module) {
		  
		  System.out.println(m.getText());
			
			 if( m.getText().equalsIgnoreCase("Risk Based Internal Audit")) {
				 wait.until(ExpectedConditions.elementToBeClickable(m)).click();
				 break; 
			 }
	  }
	  
	  psp.getAudit().click();
	  psp.getPlanSch().click();
	  psp.getPlan().click();
	  
	  WebElement AttachedTo = psp.getAttachedTO();
	  
	  Select s1=new Select(AttachedTo);
	  s1.selectByVisibleText(UtilityMethod.getProperty("AttachedTo"));
	  
	  WebElement PlanType = psp.getPlanType();
	  
	  Select s2=new Select(PlanType);
	  s2.selectByVisibleText("Annual");
	  
	  WebElement Period = psp.getPeriod();

	  if (Period.isEnabled()) {
	      Select s3 = new Select(Period);
	      s3.selectByVisibleText("1");
	      System.out.println("Period dropdown enabled — value selected.");
	  } else {
	      System.out.println("Period dropdown is disabled — skipping selection.");
	  }
	  
	  WebElement FinancialYear = psp.getFinYear();
	  
	  Select s4=new Select(FinancialYear);
	  s4.selectByVisibleText(" 2025-2026");
	  
	  
	  psp.getSearchBox().sendKeys(UtilityMethod.getProperty("BranchCode"));
	  
	  Thread.sleep(2000);
	  List<WebElement> BranchCode = psp.getBranchCode();
	  
	  for(WebElement bc: BranchCode) {
		  
		  String bcode = bc.getText();
		  
		  System.out.println(bcode);
		  
		  if(bc.getText().equalsIgnoreCase(bcode)) {
			  bc.click();
			  break;
		  }
		  
	  }
	  
	 WebElement CheckBox = d.findElement(By.xpath("//input[@id='done"+UtilityMethod.getProperty("BranchCode")+"']"));
	 CheckBox.click();
	 
	 WebElement ActMandays = d.findElement(By.xpath("//input[@id='man"+UtilityMethod.getProperty("BranchCode")+"']"));
	 ActMandays.clear();
	 ActMandays.sendKeys("10");
	 
	psp.getSave().click();
	  
  }
}
