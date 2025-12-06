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
	
	public WebElement getMaster() {
		return Master;
	}

	public WebElement getAuditee() {
		return Auditee;
	}

	public WebElement getModuleMappingMaster() {
		return ModuleMappingMaster;
	}

	public WebElement getSearchBox() {
		return SearchBox;
	}

	public List<WebElement> getBranList() {
		return BranList;
	}

	public List<WebElement> getModuleList() {
		return ModuleList;
	}

	public WebElement getCheckBox(WebElement modList) {
		return modList.findElement(By.xpath(".//input[@type='checkbox']"));
	}
	
	public WebElement getSaveButton() {
		return SaveButton;
	}

	@FindBy(xpath = "//div[@class='cls_menu_level1_options']//img[@title='Master']")
	private WebElement Master;
	
	@FindBy(xpath = "//div[@class='menuGroup6 cls_menu_level2_options_toggled']//h4[text()='Auditee']")
	private WebElement Auditee;
	
	@FindBy(xpath = "//a[text()='Module Mapping master']")
	private WebElement ModuleMappingMaster;
	
	@FindBy(xpath = "//input[@id='searchid']")
	private WebElement SearchBox;
	
	@FindBy(xpath = "//div[@class='search']//li")
	private List<WebElement> BranList;
	
	@FindBy(xpath = "//tr[contains(@class,'Rows')]")
	private List<WebElement> ModuleList;
	
	@FindBy(xpath = ".//input[@type='checkbox']")
	private WebElement CheckBox;
	
	@FindBy(xpath = "//table[@id='pagination']//button")
	private WebElement SaveButton;

}
