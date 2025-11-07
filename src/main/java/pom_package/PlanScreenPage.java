package pom_package;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Libraries.BaseClass;

public class PlanScreenPage extends BaseClass{
	
	public PlanScreenPage(WebDriver d) {
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

	public WebElement getPlan() {
		return Plan;
	}

	public WebElement getAttachedTO() {
		return AttachedTO;
	}

	public WebElement getPlanType() {
		return PlanType;
	}

	public WebElement getPeriod() {
		return Period;
	}

	public WebElement getFinYear() {
		return FinYear;
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

	@FindBy(xpath = "//a[text()='Audit Plan']")
	private WebElement Plan;

	@FindBy(xpath = "//select[@id='zoneCode']")
	private WebElement AttachedTO;

	@FindBy(xpath = "//select[@id='planType']")
	private WebElement PlanType;

	@FindBy(xpath = "//select[@id='period']")
	private WebElement Period;
	
	@FindBy(xpath = "//select[@id='finYear']")
	private WebElement FinYear;
	
	@FindBy(xpath = "//input[@id='searchid']")
	private WebElement SearchBox;
	
	@FindBy(xpath = "//div[@class='search']//li")
	private List<WebElement> BranchCode;
	
	@FindBy(xpath = "//div[@class='bottomcontent btm']//button")
	private WebElement Save;
	
	


	
}
