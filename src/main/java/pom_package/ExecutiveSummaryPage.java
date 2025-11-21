package pom_package;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExecutiveSummaryPage {

	public ExecutiveSummaryPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getExecutiveSummaryMenu() {
		return ExecutiveSummaryMenu;
	}

	public WebElement getExecutiveSummaryDataSheet() {
		return ExecutiveSummaryDataSheet;
	}

	public WebElement getIframe() {
		return Iframe;
	}

	public List<WebElement> getTextField() {
		return TextField;
	}

	public WebElement getSave() {
		return Save;
	}

	@FindBy(xpath = "//a[.='Executive Summary']")
	private WebElement ExecutiveSummaryMenu;

	@FindBy(xpath = "//li[@id='listId1']")
	private WebElement ExecutiveSummaryDataSheet;

	@FindBy(xpath = "//iframe[@id='div-content-70001']")
	private WebElement Iframe;

	@FindBy(xpath = "//textarea[contains(@id,'T1H')]")
	private List<WebElement> TextField;

	@FindBy(xpath = "//button[@id='dsSaveBtn']")
	private WebElement Save;

}
