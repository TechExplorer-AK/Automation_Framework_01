package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
@FindBy(linkText = "Register")
private WebElement registerLink;

@FindBy(linkText = "Log in")
private WebElement loginLink;

@FindBy(xpath = "//span[text()='Shopping cart']")
public WebElement shoppingCartLink;

public WelcomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getRegisterLink() {
	return registerLink;
}

public WebElement getShoppingCartLink() {
	return shoppingCartLink;
}

public WebElement getLoginLink() {
	return loginLink;
}


}
