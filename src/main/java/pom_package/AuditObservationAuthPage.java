package pom_package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuditObservationAuthPage {

	public AuditObservationAuthPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getBranchSearch() {
		return BranchSearch;
	}

	public List<WebElement> getBranchRows() {
		return BranchRows;
	}

	public WebElement getBranchRow(WebElement row) {
		return row.findElement(By.xpath(".//a[@class='userhometablehref']"));
	}

	public WebElement getBranchRow() {
		return BranchRow;
	}

	public WebElement getAuditee() {
		return Auditee;
	}

	public WebElement getAuditExecution() {
		return AuditExecution;
	}

	public WebElement getAuditObserAuth() {
		return AuditObserAuth;
	}

	public WebElement getSelectAllChecklist() {
		return SelectAllChecklist;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public List<WebElement> getSelectCheckbox() {
		return SelectCheckbox;
	}

	@FindBy(xpath = "//input[@class='checklschkboxes']")
	private List<WebElement> SelectCheckbox;

	@FindBy(xpath = "//input[@id='branchsearch']")
	private WebElement BranchSearch;

	@FindBy(xpath = "//tr[contains(@class,'Rows')]")
	private List<WebElement> BranchRows;

	@FindBy(xpath = ".//a[@class='userhometablehref']")
	private WebElement BranchRow;

	@FindBy(xpath = "//button[@id='saveaudpts']")
	private WebElement SaveButton;

	@FindBy(xpath = "//input[@id='selectallpts']")
	private WebElement SelectAllChecklist;

	@FindBy(xpath = "//div[contains(@onclick,'Audit Execution')]")
	private WebElement AuditExecution;

	@FindBy(xpath = "//div[contains(@onclick,'Audit Observation - Authorization')]")
	private WebElement AuditObserAuth;

	@FindBy(xpath = "//img[@title='Audit']")
	private WebElement Auditee;

}
