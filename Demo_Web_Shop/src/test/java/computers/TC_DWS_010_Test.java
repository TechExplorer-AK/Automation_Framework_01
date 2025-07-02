package computers;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListenerUtility;
import objectrepository.HomePage;
@Listeners(ListenerUtility.class)
public class TC_DWS_010_Test extends BaseClass {

@Test
public void clickOnDesktops() {
	HomePage hp=new HomePage(driver);
	wUtil.mouseHover(driver, hp.getComputersLink());
	hp.getDesktopsLink().click();
	Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Desktops","Desktops page is not displayed");
	test.log(Status.PASS, "Desktops page is displayed");
	Reporter.log("Desktops page is displayed",true);
    
}
}
