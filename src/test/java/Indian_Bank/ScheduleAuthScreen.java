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
import pom_package.ScheduleAuthPage;

public class ScheduleAuthScreen extends BaseClass {

	@Test
	public void ScheduleAuth() throws InterruptedException, IOException {

		ScheduleAuthPage sap = new ScheduleAuthPage(d);

		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));

		Thread.sleep(3000);
		List<WebElement> Module = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='cls_ms_module_name_wrap']//p")));

		for (WebElement m : Module) {

			System.out.println(m.getText());

			if (m.getText().equalsIgnoreCase("Risk Based Internal Audit")) {
				wait.until(ExpectedConditions.elementToBeClickable(m)).click();
				break;
			}
		}

		sap.getAudit().click();
		sap.getPlanSch().click();
		sap.getScheduleAuth().click();

		WebElement AttachedTo = sap.getAttachedTO();

		Select s1 = new Select(AttachedTo);
		s1.selectByValue(UtilityMethod.getProperty("SchZone"));

		d.findElement(By.xpath("//input[@type='checkbox' and contains(@onclick, '00017')]")).click();

		/*
		 * //Auditee Code/Name Search
		 * d.findElement(By.xpath("//input[@id='searchid']")).sendKeys("00017");
		 * 
		 * Thread.sleep(2000); List<WebElement> BranchCode =
		 * d.findElements(By.xpath("//div[@class='search']//li"));
		 * 
		 * for(WebElement bc: BranchCode) {
		 * 
		 * String bcode = bc.getText();
		 * 
		 * System.out.println(bcode);
		 * 
		 * if(bc.getText().equalsIgnoreCase(bcode)) { bc.click(); break; }
		 * 
		 * }
		 */

		sap.getSave().click();

	}

}
