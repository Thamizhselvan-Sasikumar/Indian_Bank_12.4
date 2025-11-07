package pom_package;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScheduleScreenPage {

	public ScheduleScreenPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	@FindBy(xpath = "//div[@class='cls_ms_module_name_wrap']//p")
	private WebElement Module;
	
	public WebElement getModule() {
		return Module;
	}

	public WebElement getAudit() {
		return Audit;
	}

	public WebElement getPlanSch() {
		return PlanSch;
	}

	public WebElement getSchedule() {
		return Schedule;
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

	public WebElement getGenerate() {
		return Generate;
	}

	public WebElement getBranCheckBox() {
		return BranCheckBox;
	}

	public WebElement getTeamLead() {
		return TeamLead;
	}

	public WebElement getSave() {
		return Save;
	}

	@FindBy(xpath = "//img[@title='Audit']")
	private WebElement Audit;

	@FindBy(xpath = "//h4[text()='Audit Plan & Schedule']")
	private WebElement PlanSch;

	@FindBy(xpath = "//a[text()='Audit Schedule']")
	private WebElement Schedule;

	@FindBy(xpath = "//select[@id='zoneCode']")
	private WebElement AttachedTO;
	
	@FindBy(xpath = "//input[@id='searchid']")
	private WebElement SearchBox;

	@FindBy(xpath = "//div[@class='search']//li")
	private List<WebElement> BranchCode;

	@FindBy(xpath = "//button[text()='Generate']")
	private WebElement Generate;
	
	@FindBy(xpath = "//input[@id='cb1']")
	private WebElement BranCheckBox;
	
	@FindBy(xpath = "//input[@id='teamLeadName1']/following-sibling::a")
	private WebElement TeamLead;
	
	@FindBy(xpath = "//div[@class='bottomcontent btm ']//button[text()='Save']")
	private WebElement Save;
	
}
