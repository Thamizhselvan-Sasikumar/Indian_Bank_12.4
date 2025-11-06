package Indian_Bank;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic_Libraries.BaseClass;
import generic_Libraries.UtilityMethod;
import pom_package.ModuleMappingPage;

public class ModuleMapping extends BaseClass {

	@Test
	public void modulemapping() throws IOException {

		ModuleMappingPage mmp = new ModuleMappingPage(d);

		//Master Menu
		mmp.getMasterMenu().click();

		//Auditee Menu
		mmp.getAuditeeMenu().click();

		//Module Mapping Master Menu
		mmp.getModuleMappingMasterMenu().click();

		//Branch Search Box
		mmp.getBranchSearch().sendKeys(UtilityMethod.getProperty("BranchCode"));

		//Branch List

		List<WebElement> branchList = d.findElements(By.xpath("//div[@class='search']//li"));

		for (WebElement bl : branchList) {

			bl.getText().equalsIgnoreCase("00003");
			bl.click();
			break;
		}

		List<WebElement> moduleList = d.findElements(By.xpath("//tbody[@class='sticky_tbody']//tr"));

		for (WebElement ml : moduleList) {

			ml.getText().equalsIgnoreCase("Treasury Branch");
			String text = ml.getText();
			System.out.println(text);
			
			
		}

	}

}
