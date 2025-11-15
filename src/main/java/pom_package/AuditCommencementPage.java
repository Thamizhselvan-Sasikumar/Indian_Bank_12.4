package pom_package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Libraries.BaseClass;

public class AuditCommencementPage extends BaseClass{
	
	public AuditCommencementPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	@FindBy(xpath = "//input[@id='branchsearch']")
	private WebElement BranchSearch;
	
	@FindBy(xpath = "//tr[contains(@class,'Rows')]")
	private List<WebElement> BranchRow;
	
	@FindBy(xpath = ".//a[@class='userhometablehref']")
	private WebElement BranchSelection;
	
	@FindBy(xpath = "//img[@title='Audit']")
	private WebElement Audit;
	
	@FindBy(xpath = "//div[contains(@onclick,'Audit Execution')]")
	private WebElement AuditExecution;
	
	@FindBy(xpath = "//div[contains(@onclick,'Audit Commencement')]")
	private WebElement AuditCommencement;
	
	@FindBy(xpath = "//input[@id='btnsubmit']")
	private WebElement Save;
	
	public WebElement getBranchSearch() {
		return BranchSearch;
	}

	public List<WebElement> getBranchRow() {
		return BranchRow;
	}

	public WebElement getBranchSelection(WebElement row) {
		return row.findElement(By.xpath(".//a[@class='userhometablehref']"));
	}

	public WebElement getAudit() {
		return Audit;
	}

	public WebElement getAuditExecution() {
		return AuditExecution;
	}

	public WebElement getAuditCommencement() {
		return AuditCommencement;
	}

	public WebElement getSave() {
		return Save;
	}

	
}
