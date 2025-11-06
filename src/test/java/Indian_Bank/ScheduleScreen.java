package Indian_Bank;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;

public class ScheduleScreen extends BaseClass {
  @Test
  public void schedule() throws InterruptedException, IOException {
	  
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
		  
		  d.findElement(By.xpath("//img[@title='Audit']")).click();
		  d.findElement(By.xpath("//h4[text()='Audit Plan & Schedule']")).click();
		  d.findElement(By.xpath("//a[text()='Audit Schedule']")).click();
		  
		  WebElement AttachedTo = d.findElement(By.xpath("//select[@id='zoneCode']"));
		  
		  Select s1=new Select(AttachedTo);
		  s1.selectByValue("0001");
		  
 d.findElement(By.xpath("//input[@id='searchid']")).sendKeys("81025");
		  
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
		  
		  WebElement generate = d.findElement(By.xpath("//button[text()='Generate']"));
		  generate.click();
		  
		  
		  d.findElement(By.xpath("//input[@id='cb1']")).click();
		  
		  d.findElement(By.xpath("//input[@id='teamLeadName1']/following-sibling::a")).click();	
		  
		  Thread.sleep(2000);
		  WebElement radio = wait.until(ExpectedConditions.elementToBeClickable(
				    By.id(UtilityMethod.getProperty("TL") + "CB")));
		  radio.click();
			
		  Thread.sleep(3000);
		  WebElement fromDate = wait.until(ExpectedConditions.elementToBeClickable(
				    By.xpath("//input[@id='fromDate1']")
				));

				fromDate.click();
		  
		  Actions a = new Actions(d);
		  a.sendKeys(Keys.ENTER).perform();
		  
		d.findElement(By.xpath("//div[@class='bottomcontent btm ']//button[text()='Save']")).click();
			
  }
}
