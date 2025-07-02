package genericutility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
/**
 * @author aniket
 */
public class WebDriverUtility {
/**
 * This method is used to maximize the window
 * @param driver
 */
public void maximize(WebDriver driver) {
	driver.manage().window().maximize();
}
/**
 * This is used to mouse hover on the web element
 * @param driver
 * @param element
 */
public void mouseHover(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 * This is used to perform click on hold operation on web element
 * @param driver
 * @param element
 */
public void clickAndHold(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.clickAndHold(element).perform();	
}
/**
 * This is used to perform drag and drop operation on the web element
 * @param driver
 * @param source
 * @param target
 */
public void dragAndDrop(WebDriver driver,WebElement source, WebElement target) {
	Actions act=new Actions(driver);
	act.dragAndDrop(source,target).perform();
}
/**
 * This is used to select the option by using index
 * @param element
 * @param index
 */
public void selectByIndex(WebElement element,int index) {
	Select sel=new Select(element);
	sel.selectByIndex(index);
}
/**
 * This is used to select the option by using value
 * @param element
 * @param value
 */
public void  selectByValue(WebElement element, String value) {
	Select sel=new Select(element);
	sel.selectByValue(value);
}
/**
 * This is used to select the option by using Visible text
 * @param element
 * @param text
 */
public void selectByVisibleText(WebElement element,String text) {
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
}
/**
 * This method will return all the dropdown options in text format
 * @param element
 * @return
 */
public List<String> getAllOptions(WebElement element) {
	Select sel=new Select(element);
	List<WebElement> alloptions = sel.getOptions();
	List<String> options=new ArrayList<String>();
	for(WebElement opt:alloptions) {
		options.add(opt.getText());
	}
	return options;
}
/**
 * It is used to switch to frame using index
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);
}
/**
 * It is used to switch to frame using id or name attribute
 * @param driver
 * @param nameOrId
 */
public void switchToFrame(WebDriver driver,String nameOrId) {
	driver.switchTo().frame(nameOrId);
}
/**
 * It is used to switch to frame using WebElement
 * @param driver
 * @param element
 */
public void switchToFrame(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
/**
 * Used to switch back to main webpage
 * @param driver
 */
public void switchBackToMainPage(WebDriver driver) {
	driver.switchTo().defaultContent();
}
public void switchToAlert(WebDriver driver) {
	driver.switchTo().alert();
}
public void switchToWindow(WebDriver driver, String expUrl) {
	Set<String> allIds = driver.getWindowHandles();
	for(String id:allIds ) {
		driver.switchTo().window(id);
		if(driver.getCurrentUrl().equals(expUrl))
			break;
	}
}
public void getPhoto(WebDriver driver) throws IOException {
	JavaUtility jutil=new JavaUtility();
	TakesScreenshot ts=(TakesScreenshot) driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("./screenshots/"+jutil.getSystemTime()+".png");
	FileHandler.copy(temp, dest);
}
public void jsScroll(WebDriver driver, int x, int y) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollTo("+x+","+y+")");
}
}
