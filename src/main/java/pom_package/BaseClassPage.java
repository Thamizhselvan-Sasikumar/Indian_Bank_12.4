package pom_package;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Libraries.BaseClass;


public class BaseClassPage extends BaseClass {
	
	public BaseClassPage(WebDriver d) {

		PageFactory.initElements(d, this);
	}
	
	public WebElement getDetailButton() {
		return DetailButton;
	}

	public WebElement getProceedLink() {
		return ProceedLink;
	}

	public WebElement getUserID() {
		return UserID;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	public WebElement getLogout() {
		return Logout;
	}

	@FindBy(id ="details-button")
	private WebElement DetailButton;
	
	@FindBy(id ="proceed-link")
	private WebElement ProceedLink;
	
	@FindBy(id ="userid")
	private WebElement UserID;
	
	@FindBy(id ="kadavuSol")
	private WebElement Password;
	
	@FindBy(xpath ="//button[text()='Log in']")
	private WebElement LoginButton;
	
	@FindBy(xpath ="//img[@title='Logout']")
	private WebElement Logout;
	
	public List<WebElement> getBranchRows() {
		return branchRows;
	}

	@FindBy(xpath = "//tr[contains(@class,'Rows')]")
    private List<WebElement> branchRows;

}
