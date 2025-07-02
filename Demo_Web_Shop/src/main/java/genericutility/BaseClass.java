package genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.WelcomePage;
//Declaring reusable variables globally
public class BaseClass {
public static ExtentReports ereport;

public JavaUtility jutil=new JavaUtility();
public static WebDriver driver;
public WebDriverUtility wUtil=new WebDriverUtility();
public FileUtility fUtil=new FileUtility();
public static ExtentTest test;

@BeforeSuite
public void reportConfig() {
	ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/"+jutil.getSystemTime()+".html");
	ereport=new ExtentReports();
	ereport.attachReporter(spark);
}
@BeforeClass
public void openBrowser() throws IOException {
	driver=new ChromeDriver();
	wUtil.maximize(driver);
	driver.get(fUtil.getDataFromProperty("url"));
}
@BeforeMethod
public void login() throws IOException {
	WelcomePage wp=new WelcomePage(driver);
	wp.getLoginLink().click();
	LoginPage lp=new LoginPage(driver);
	lp.getEmailTF().sendKeys(fUtil.getDataFromProperty("email"));
	lp.getPasswordTF().sendKeys(fUtil.getDataFromProperty("password"));
	lp.getLoginButton().click();
}
@AfterMethod
public void logout() {
	HomePage hp=new HomePage(driver);
	hp.getLogoutLink().click();
}
@AfterClass
public void closeBrowser() {
	driver.quit();
}
@AfterSuite
public void reportBackup() {
	ereport.flush();
}
}
