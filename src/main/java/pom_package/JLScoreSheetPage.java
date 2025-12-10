package pom_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic_Libraries.BaseClass;

public class JLScoreSheetPage extends BaseClass {
	
	public JLScoreSheetPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	

}
