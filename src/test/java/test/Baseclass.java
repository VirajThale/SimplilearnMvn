package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Baseclass 

{
	public static ExtentReports report;
	public static ExtentTest test;
	public static WebDriver dr;
	XSSFWorkbook wbook;
	XSSFSheet sheet;
	DesiredCapabilities cap = new DesiredCapabilities();

	
	@BeforeTest
	public void ReportSetup() throws IOException {
		report =new ExtentReports("ExtentReport.html");
		FileInputStream  fis= new FileInputStream ("exceldata.xlsx");
		wbook = new XSSFWorkbook(fis);
		sheet= wbook.getSheet("data");
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver","chromedriver");
		setDriver();
	   
		dr.get("https://www.simplilearn.com/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
	}
	
	@AfterMethod
	public void teardown() {
		dr.quit();
}
	
	@AfterTest
	public void ReportTearDown() throws IOException {
		report.flush();
		report.close();
		wbook.close();
		
	}
	
	public void setDriver() throws IOException {
		InputStream input  = new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(input);
		String BrowserName = prop.getProperty("browser");
		if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","chromedriver");
			dr =new ChromeDriver();
			
		}else {
			cap.setPlatform(Platform.LINUX);
			cap.setBrowserName("chrome");
			URL url  = new URL(" http://172.17.0.1:4444/wd/hub");
			dr = new RemoteWebDriver(url, cap);
		}
	}

}
