package pages;
import test.Baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver dr= Baseclass.dr;
	
	//+++++++WebElements+++++++++++
	
	
	

	
	
	//+++++++Constructor+++++++++++
	public HomePage() {
		PageFactory.initElements(dr, this);
	}
	
	public void methodname() {
		
	}


}
