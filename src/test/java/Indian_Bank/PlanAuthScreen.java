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
import pom_package.PlanAuthScreenPage;

public class PlanAuthScreen extends BaseClass{
	
  @Test
  public void planAuth() throws InterruptedException, IOException {
	  
	  PlanAuthScreenPage pas=new PlanAuthScreenPage();
	  
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
		  
		  pas.getAudit().click();
		  d.findElement(By.xpath("//h4[text()='Audit Plan & Schedule']")).click();
		  d.findElement(By.xpath("//a[text()='Audit Plan Authorization']")).click();
		  
		  WebElement AttachedTo = d.findElement(By.xpath("//select[@id='zoneCode']"));
		  
		  Select s1=new Select(AttachedTo);
		  s1.selectByVisibleText("0001-RANIPET");
		  
		  WebElement PlanType = d.findElement(By.xpath("//select[@id='planType']"));
		  
		  Select s2=new Select(PlanType);
		  s2.selectByVisibleText("Annual");
		  
		  WebElement Period = d.findElement(By.xpath("//select[@id='period']"));

		  if (Period.isEnabled()) {
		      Select s3 = new Select(Period);
		      s3.selectByVisibleText("1");
		      System.out.println("Period dropdown enabled — value selected.");
		  } else {
		      System.out.println("Period dropdown is disabled — skipping selection.");
		  }
		  
		  WebElement FinancialYear = d.findElement(By.xpath("//select[@id='finYear']"));
		  
		  Select s4=new Select(FinancialYear);
		  s4.selectByVisibleText(" 2025-2026");
		  
		  
		  d.findElement(By.xpath("//input[@id='searchid']")).sendKeys(UtilityMethod.getProperty("BranchCode"));
		  
		  Thread.sleep(2000);
		  List<WebElement> BranchCode = d.findElements(By.xpath("//div[@class='search']//li"));
		  
		  for(WebElement bc: BranchCode) {
			  
			  String bcode = bc.getText();
			  
			  System.out.println(bcode);
			  
			  if(bc.getText().equalsIgnoreCase(bcode)) {
				  bc.click();
				  break;
			  }
			  
		  }
		  
		WebElement AuthCheckBox = d.findElement(By.xpath("//input[@id='done"+UtilityMethod.getProperty("BranchCode")+"']"));
		AuthCheckBox.click();
			 
		WebElement AuthMandays = d.findElement(By.xpath("//input[@id='Authman"+UtilityMethod.getProperty("BranchCode")+"']"));
		AuthMandays.clear();
		AuthMandays.sendKeys("20");
			 
		d.findElement(By.xpath("//div[@class='bottomcontent btm']//button")).click();
  }
}
