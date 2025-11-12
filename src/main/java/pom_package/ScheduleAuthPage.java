package pom_package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Libraries.BaseClass;

public class ScheduleAuthPage extends BaseClass{
	
	public ScheduleAuthPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	public WebElement getModule() {
		return Module;
	}

	public WebElement getAudit() {
		return Audit;
	}

	public WebElement getPlanSch() {
		return PlanSch;
	}

	public WebElement getScheduleAuth() {
		return ScheduleAuth;
	}

	public WebElement getAttachedTO() {
		return AttachedTO;
	}

	public WebElement getSearchBox() {
		return SearchBox;
	}

	public List<WebElement> getBranchCode() {
		return BranchCode;
	}

	public WebElement getSave() {
		return Save;
	}

	@FindBy(xpath = "//div[@class='cls_ms_module_name_wrap']//p")
	private WebElement Module;
	
	@FindBy(xpath = "//img[@title='Audit']")
	private WebElement Audit;

	@FindBy(xpath = "//h4[text()='Audit Plan & Schedule']")
	private WebElement PlanSch;

	@FindBy(xpath = "//a[text()='Audit Schedule Authorization']")
	private WebElement ScheduleAuth;

	@FindBy(xpath = "//select[@id='zoneCode']")
	private WebElement AttachedTO;
	
	@FindBy(xpath = "//input[@id='searchid']")
	private WebElement SearchBox;

	@FindBy(xpath = "//div[@class='search']//li")
	private List<WebElement> BranchCode;
	
	public List<WebElement> getBranchCodeRows() {
		return BranchCodeRows;
	}

	public WebElement getCheckBox(WebElement row) {
		return row.findElement(By.xpath(".//input[@type='checkbox']"));
	}

	@FindBy(xpath = "//tr[contains(@class,'Rows')]")
	private List<WebElement> BranchCodeRows;
	
	@FindBy(xpath = ".//input[@type='checkbox']")
	private WebElement CheckBox;
	
	@FindBy(xpath = "//button[@id='SaveData']")
	private WebElement Save;

}
