package pom_package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModuleMappingPage {
	
	public ModuleMappingPage(WebDriver d) {

		PageFactory.initElements(d, this);
	}
	
	public WebElement getMasterMenu() {
		return MasterMenu;
	}

	public WebElement getAuditeeMenu() {
		return AuditeeMenu;
	}

	public WebElement getModuleMappingMasterMenu() {
		return ModuleMappingMasterMenu;
	}

	public WebElement getBranchSearch() {
		return BranchSearch;
	}

	
	public WebElement getModuleList() {
		return ModuleList;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	@FindBy(xpath = "//div[@class='cls_menu_level1_options']//img[@title='Master']")
	private WebElement MasterMenu;

	@FindBy(xpath = "//div[@class='menuGroup6 cls_menu_level2_options_toggled']//h4[text()='Auditee']")
	private WebElement AuditeeMenu;

	@FindBy(xpath = "//a[text()='Module Mapping master']")
	private WebElement ModuleMappingMasterMenu;

	@FindBy(xpath = "//input[@id='searchid']")
	private WebElement BranchSearch;
	
	public WebElement getCheckBox(WebElement row) {
		return row.findElement(By.xpath(".//input[contains(@id,'checkFlag')]"));
	}

	@FindBy(xpath = ".//input[contains(@id,'checkFlag')]")
	private WebElement CheckBox;
	
	public List<WebElement> getBranchList() {
		return BranchList;
	}

	@FindBy(xpath = "//div[@class='search']//li")
	private List<WebElement> BranchList;
	
	public List<WebElement> getModList() {
		return ModList;
	}

	@FindBy(xpath = "//tr[contains(@class,'Rows')]")
	private List<WebElement> ModList;
	
	@FindBy(xpath = "//tbody[@class='sticky_tbody']//tr") //Module list
	private WebElement ModuleList;
	
	@FindBy(xpath = "//table[@id='pagination']//button")
	private WebElement SaveButton;
	

	
	
}
