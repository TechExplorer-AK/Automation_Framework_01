package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
@FindBy(partialLinkText = "BOOKS")
private WebElement booksLink;

@FindBy(partialLinkText = "COMPUTERS")
private WebElement computersLink;

@FindBy(partialLinkText = "ELECTRONICS")
private WebElement electronicsLink;

@FindBy(partialLinkText = "APPAREL & SHOES")
private WebElement apparelAndShoesLink;

@FindBy(partialLinkText = "DIGITAL DOWNLOADS")
private WebElement digitalDownloadsLink;

@FindBy(partialLinkText = "JEWELRY")
private WebElement jewelryLink;

@FindBy(linkText = "Log out")
private WebElement logoutLink;

@FindBy(partialLinkText = "Desktops")
private WebElement desktopsLink;

@FindBy(partialLinkText = "Cell phones")
private WebElement cellPhonesLink;

public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public WebElement getCellPhonesLink() {
	return cellPhonesLink;
}
public WebElement getDesktopsLink() {
	return desktopsLink;
}
public WebElement getBooksLink() {
	return booksLink;
}
public WebElement getComputersLink() {
	return computersLink;
}
public WebElement getElectronicsLink() {
	return electronicsLink;
}
public WebElement getApparelAndShoesLink() {
	return apparelAndShoesLink;
}
public WebElement getDigitalDownloadsLink() {
	return digitalDownloadsLink;
}
public WebElement getJewelryLink() {
	return jewelryLink;
}

public WebElement getLogoutLink() {
	return logoutLink;
}




}
