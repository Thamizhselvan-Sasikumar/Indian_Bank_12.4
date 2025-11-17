package pom_package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuditObservationPage {
	
	public AuditObservationPage(WebDriver d) {
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

	public WebElement getAuditObservationMenu() {
		return AuditObservationMenu;
	}

	public WebElement getCustomerSearchIcon() {
		return CustomerSearchIcon;
	}

	public WebElement getBranchSelection() {
		return BranchSelection;
	}

	public WebElement getCustomerSearchBox() {
		return CustomerSearchBox;
	}

	public List<WebElement> getCustomerLists() {
		return CustomerLists;
	}
	
	public List<WebElement> getCustomerRows() {
		return CustomerRows;
	}
	
	public WebElement getCustomerCheckBox(WebElement custRow) {
		return custRow.findElement(By.xpath(".//input[@type='radio']"));
	}
	
	public WebElement getCustomerCheckBox() {
		return CustomerCheckBox;
	}

	public List<WebElement> getChecklistDropdown() {
		return ChecklistDropdown;
	}

	public WebElement getAuditorComment() {
		return AuditorComment;
	}

	public WebElement getChecklistSaveButton() {
		return ChecklistSaveButton;
	}

	public WebElement getOverallSaveButton() {
		return OverallSaveButton;
	}
	
	public WebElement getAuditType() {
		return AuditType;
	}

	public WebElement getSelectAll() {
		return SelectAll;
	}

	public WebElement getNextButton() {
		return NextButton;
	}

	public WebElement getMandatoryChecklist() {
		return MandatoryChecklist;
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
	
	@FindBy(xpath = "//a[text()='Audit Observation']")
	private WebElement AuditObservationMenu;
	
	@FindBy(xpath = "//input[@id='custSearchSL']/following-sibling::i")
	private WebElement CustomerSearchIcon;
	
	@FindBy(xpath = "//div[@class='popuptextbox']//input")
	private WebElement CustomerSearchBox;
	
	@FindBy(xpath = "//div[@class='popupcontent p-b-b']//li")
	private List<WebElement> CustomerLists;
	
	@FindBy(xpath = "//table[@id='accounts']//tr[contains(@class,'Rows')]")
	private List<WebElement> CustomerRows;
	
	@FindBy(xpath = ".//input[@type='radio']")
	private WebElement CustomerCheckBox;
	
	@FindBy(xpath = "//select[contains(@id,'irrSelect')]")
	private List<WebElement> ChecklistDropdown;
	
	@FindBy(xpath = "//textarea[@id='auditorcomnts']")
	private WebElement AuditorComment;
	
	@FindBy(xpath = "//button[@id='auditObsSave']")
	private WebElement ChecklistSaveButton;
	
	@FindBy(xpath = "//button[@id='saveprodbtn']")
	private WebElement OverallSaveButton;
	
	@FindBy(xpath = "//select[@id='auditType']")
	private WebElement AuditType;
	
	@FindBy(xpath = "//input[@id='prodSelectAll']")
	private WebElement SelectAll;
	
	@FindBy(xpath = "//button[@id='nextbtn']")
	private WebElement NextButton;
	
	@FindBy(xpath = "//select[@id='irrSelect53']")
	private WebElement MandatoryChecklist;
	
	public WebElement getBackButton() {
		return BackButton;
	}

	@FindBy(xpath = "//button[@id='backbtn']")
	private WebElement BackButton;
	
	

}
