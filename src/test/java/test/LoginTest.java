package test;



import java.io.IOException;


//import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginPage ;

public class LoginTest extends Baseclass


{
	@Parameters({"Username","Password"})
	@Test(enabled=true)
	public void NegativeLogin(String UsernameVal, String PasswordVal) 
	
	{
		test= report.startTest("Negative Login Test");
		LoginPage login = new LoginPage();
		login.Login(UsernameVal, PasswordVal);
		login.ErrorCheck();
		report.endTest(test);
		Assert.assertTrue(false);
		
		
	}
	
	@Parameters({"Username","CPassword"})
	@Test(enabled= true)
	public void PositiveLogin(String UsernameVal, String PasswordVal) {
		
		test= report.startTest("Positive Login Test");
		LoginPage login = new LoginPage();
		login.Login(UsernameVal, PasswordVal);
		report.endTest(test);
		
	}
	
	@Test
	public void ExcelTest() throws IOException {
		
		
		String UsernameVal =sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal =sheet.getRow(1).getCell(1).getStringCellValue();
		
		test= report.startTest("Negative Login Test");
		LoginPage login = new LoginPage();
		login.Login(UsernameVal, PasswordVal);
		report.endTest(test);
		
	
	}
		
	
	
	
	

}

