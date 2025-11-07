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
import pom_package.ScheduleScreenPage;

public class ScheduleScreen extends BaseClass {
	@Test
	public void schedule() throws InterruptedException, IOException {

		ScheduleScreenPage ssp = new ScheduleScreenPage(d);

		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));

		Thread.sleep(3000);
		List<WebElement> Module = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='cls_ms_module_name_wrap']//p")));

		for (WebElement m : Module) {

			System.out.println(m.getText());

			if (m.getText().equalsIgnoreCase(UtilityMethod.getProperty("Module"))) {
				wait.until(ExpectedConditions.elementToBeClickable(m)).click();
				break;
			}
		}

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

		ssp.getBranCheckBox().click();

		ssp.getTeamLead().click();

		Thread.sleep(2000);
		WebElement radio = wait
				.until(ExpectedConditions.elementToBeClickable(By.id(UtilityMethod.getProperty("TL") + "CB")));
		radio.click();

		Thread.sleep(3000);
		WebElement fromDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='fromDate1']")));

		fromDate.click();

		Actions a = new Actions(d);
		a.sendKeys(Keys.ENTER).perform();

		ssp.getSave().click();

	}
}
