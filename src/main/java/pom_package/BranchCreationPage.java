package pom_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Libraries.BaseClass;

public class BranchCreationPage extends BaseClass {

	public BranchCreationPage(WebDriver d) {

		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//div[@class='cls_menu_level1_options']//img[@title='Master']")
	private WebElement MasterMenu;

	@FindBy(xpath = "//div[@class='menuGroup6 cls_menu_level2_options_toggled']//h4[text()='Auditee']")
	private WebElement AuditeeMenu;

	@FindBy(xpath = "//a[text()='Branch Master']")
	private WebElement BranchMasterMenu;

	@FindBy(xpath = "//button[text()='Add']")
	private WebElement AddButton;

	@FindBy(xpath = "//input[@id='brancd']")
	private WebElement BranchCode;

	@FindBy(xpath = "//input[@id='brannm']")
	private WebElement BranchName;

	@FindBy(xpath = "//select[@id='branSize']")
	private WebElement BranchSize;

	@FindBy(xpath = "//select[@id='mainCd']")
	private WebElement MainBranch;

	@FindBy(xpath = "//input[@id='address1']")
	private WebElement Address;

	@FindBy(xpath = "//input[@id='bsrcode']")
	private WebElement BSRCode;

	@FindBy(xpath = "//input[@id='opendate']")
	private WebElement OpenDate;

	@FindBy(xpath = "//select[@title='Change the year']")
	private WebElement Year;

	@FindBy(xpath = "//select[@title='Change the month']")
	private WebElement Month;

	@FindBy(xpath = "//div[@class='datepick-month']/table/tbody//td")
	private WebElement Date;

	@FindBy(xpath = "//select[@id='catogry']")
	private WebElement BranchType;

	@FindBy(xpath = "//select[@id='rbiaType']")
	private WebElement RBIAType;

	@FindBy(xpath = "//input[@id='city']")
	private WebElement City;

	@FindBy(xpath = "//input[@id='pinNum']")
	private WebElement Pincode;

	@FindBy(xpath = "//tr[@id='st']//i")
	private WebElement StateSearch;

	@FindBy(xpath = "//div[@class='popupcontent p-b-b']//li")
	private WebElement StateList;

	@FindBy(xpath = "//tr[@id='dist']//i")
	private WebElement DistrictSearch;

	@FindBy(xpath = "//div[@class='popupcontent p-b-b']//li")
	private WebElement DistrictList;

	@FindBy(xpath = "//input[@id='mobileNo']")
	private WebElement MobileNumber;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement EmailAddress;

	@FindBy(xpath = "//select[@id='forEx']")
	private WebElement Forex;

	@FindBy(xpath = "//input[@id='fromval']")
	private WebElement FromTime;

	@FindBy(xpath = "//input[@id='toval']")
	private WebElement ToTime;

	@FindBy(xpath = "//select[@id='wklyFull']")
	private WebElement WeeklyHoliday;

	@FindBy(xpath = "//tr[@id='zo']//i")
	private WebElement AttachedToSearch;

	@FindBy(xpath = "//div[@class='popupcontent p-b-b']//li")
	private WebElement AttachedToList;

	@FindBy(xpath = "//input[@id='effectiveFrom']")
	private WebElement FromDate;

	@FindBy(xpath = "//tr[@id='bc']//i")
	private WebElement BranchCategorySearch;

	@FindBy(xpath = "//div[@class='popupcontent p-b-b']//li")
	private WebElement BranchCategoryList;

	// Getter Method

	public WebElement getMasterMenu() {
		return MasterMenu;
	}

	public WebElement getAuditeeMenu() {
		return AuditeeMenu;
	}

	public WebElement getBranchMasterMenu() {
		return BranchMasterMenu;
	}

	public WebElement getAddButton() {
		return AddButton;
	}

	public WebElement getBranchCode() {
		return BranchCode;
	}

	public WebElement getBranchName() {
		return BranchName;
	}

	public WebElement getBranchSize() {
		return BranchSize;
	}

	public WebElement getMainBranch() {
		return MainBranch;
	}

	public WebElement getAddress() {
		return Address;
	}

	public WebElement getBSRCode() {
		return BSRCode;
	}

	public WebElement getOpenDate() {
		return OpenDate;
	}

	public WebElement getYear() {
		return Year;
	}

	public WebElement getMonth() {
		return Month;
	}

	public WebElement getDate() {
		return Date;
	}

	public WebElement getBranchType() {
		return BranchType;
	}

	public WebElement getRBIAType() {
		return RBIAType;
	}

	public WebElement getCity() {
		return City;
	}

	public WebElement getPincode() {
		return Pincode;
	}

	public WebElement getStateSearch() {
		return StateSearch;
	}

	public WebElement getStateList() {
		return StateList;
	}

	public WebElement getDistrictSearch() {
		return DistrictSearch;
	}

	public WebElement getDistrictList() {
		return DistrictList;
	}

	public WebElement getMobileNumber() {
		return MobileNumber;
	}

	public WebElement getEmailAddress() {
		return EmailAddress;
	}

	public WebElement getForex() {
		return Forex;
	}

	public WebElement getFromTime() {
		return FromTime;
	}

	public WebElement getToTime() {
		return ToTime;
	}

	public WebElement getWeeklyHoliday() {
		return WeeklyHoliday;
	}

	public WebElement getAttachedToSearch() {
		return AttachedToSearch;
	}

	public WebElement getAttachedToList() {
		return AttachedToList;
	}

	public WebElement getFromDate() {
		return FromDate;
	}

	public WebElement getBranchCategorySearch() {
		return BranchCategorySearch;
	}

	public WebElement getBranchCategoryList() {
		return BranchCategoryList;
	}

}
