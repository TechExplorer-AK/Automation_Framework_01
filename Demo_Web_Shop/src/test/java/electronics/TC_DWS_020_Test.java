package electronics;

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
public class TC_DWS_020_Test extends BaseClass {
@Test
public void clickOnCellPhones() {
	HomePage hp=new HomePage(driver);
	wUtil.mouseHover(driver, hp.getElectronicsLink());
	
	hp.getCellPhonesLink().click();
	Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Cell phones","Cell phones page is not displayed");
	test.log(Status.PASS, "Cell phones page is displayed");
	Reporter.log("Cell phones page is displayed",true);
}
}
