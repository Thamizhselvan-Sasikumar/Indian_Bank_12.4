package pom_package;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Libraries.BaseClass;

public class ScheduleAuthPage extends BaseClass{
	
	public ScheduleAuthPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	@FindBy(xpath = "//div[@class='cls_ms_module_name_wrap']//p")
	private WebElement Module;
	
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

}
