package pom_package;

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

	public WebElement getBranchList() {
		return BranchList;
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
	
	@FindBy(xpath = "//div[@class='search']//li")
	private WebElement BranchList;
	
	@FindBy(xpath = "//tbody[@class='sticky_tbody']//tr") //Module list
	private WebElement ModuleList;
	
	@FindBy(xpath = "//button[normalize-space(text())='SAVE']")
	private WebElement SaveButton;
	

	
	
}
