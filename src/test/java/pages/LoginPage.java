package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.Baseclass;



public class LoginPage  
{
		ExtentTest test = Baseclass.test;
		WebDriver dr= Baseclass.dr;
		
		@FindBy(linkText ="Log in")
		WebElement LoginLink;
		
		@FindBy(linkText ="Log in")
		WebElement LoginLink1;
		
		@FindBy(name ="user_login")
		WebElement Username;
		
		@FindBy(id ="password")
		WebElement password;
		
		@FindBy(name ="btn_login")
		WebElement btn_login; 
		
		public LoginPage() {
			PageFactory.initElements(dr, this);
		}

		
		public void Login(String UnameVal, String PwdVal) {
			
			
			
			WebDriverWait wait= new WebDriverWait(dr,30);
			wait.until(ExpectedConditions.visibilityOf(LoginLink));
			
		    LoginLink1.click();
		    test.log(LogStatus.PASS,"Successfully Clicked on Login link");
			Username.sendKeys(UnameVal);
			test.log(LogStatus.PASS,"Successfully Entered the Name ");
			
			password.sendKeys(PwdVal);
			test.log(LogStatus.PASS,"Successfully Entered the Password ");

			btn_login.click();
		    test.log(LogStatus.PASS,"Successfully Clicked on Login Button");

		}
		
		public void ErrorCheck() {
			
			WebElement error= dr.findElement(By.id("msg_box"));
			String Actualmsg= error.getText();
			String Expmsg ="The email or password you have entered is invalid.";
			
			//Assert.assertEquals(Actualmsg, Expmsg); //only can use in @Test
			
			SoftAssert soft =new SoftAssert();
			soft.assertEquals(Actualmsg, Expmsg);
			System.out.println("After Assertion:Login check");
			soft.assertAll();
		}
		



}
