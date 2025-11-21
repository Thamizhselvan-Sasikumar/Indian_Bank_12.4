package pom_package;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Libraries.BaseClass;

public class JLScoreSheetPage extends BaseClass {
	
	public JLScoreSheetPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	public WebElement getJLScoreSheetMenu() {
		return JLScoreSheetMenu;
	}

	public List<WebElement> getStatusDropdowns() {
		return StatusDropdowns;
	}

	public List<WebElement> getTextField() {
		return TextField;
	}

	public List<WebElement> getRiskDropdowns() {
		return RiskDropdowns;
	}

	public WebElement getUploadButton() {
		return UploadButton;
	}

	public WebElement getChooseFile() {
		return ChooseFile;
	}

	public WebElement getClickToUpload() {
		return ClickToUpload;
	}

	public WebElement getSave() {
		return Save;
	}

	@FindBy(xpath = "//a[.='JL Score Sheet']")
	private WebElement JLScoreSheetMenu;
	
	@FindBy(xpath = "//select[contains(@id,'cmmds')]")
	private List<WebElement> StatusDropdowns;
	
	@FindBy(xpath = "//textarea[contains(@id,'textarea')]")
	private List<WebElement> TextField;
	
	@FindBy(xpath = "//select[contains(@id,'risk')]")
	private List<WebElement> RiskDropdowns;
	
	@FindBy(xpath = "//a[@id='uploadbtn']")
	private WebElement UploadButton;
	
	@FindBy(xpath = "//input[@id='filetext']")
	private WebElement ChooseFile;
	
	@FindBy(xpath = "//button[@id='updsavebutton']")
	private WebElement ClickToUpload;
	
	@FindBy(xpath = "//button[.='SAVE']")
	private WebElement Save;
	

}
