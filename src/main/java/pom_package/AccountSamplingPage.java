package pom_package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSamplingPage {
	
	public AccountSamplingPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
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

	public WebElement getAccountSamplingMenu() {
		return AccountSamplingMenu;
	}

	public WebElement getAccountNumber() {
		return AccountNumber;
	}

	public List<WebElement> getAccountLists() {
		return AccountLists;
	}

	public WebElement getSave() {
		return Save;
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
	
	@FindBy(xpath = "//a[text()='Account Sampling']")
	private WebElement AccountSamplingMenu;

	@FindBy(xpath = "//input[@id='searchid']")
	private WebElement AccountNumber;
	
	@FindBy(xpath = "//div[@class='search']//li")
	private List<WebElement> AccountLists;
	
	@FindBy(xpath = "//button[@id='savebtn']")
	private WebElement Save;

}
