package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtils;

import java.util.List;

public class MyAccountPage {

    private ElementUtils elementUtils;

    public MyAccountPage(WebDriver driver){
        elementUtils = new ElementUtils(driver);
    }

    //By locators:
    private By accountSectionList = By.cssSelector("div#content h2");
    private By accountPageLogo = By.cssSelector("div#logo a");
    private By logoutLink = By.linkText("Logout");


    //Page functions:
    public String getAccountPageTitle(){
        return elementUtils.waitForTitle(5, "My Account");
    }

    public String getAccountPageUrl(){
        return elementUtils.getPageURL();
    }

    public List<String> getAccountSectionList(){
        return elementUtils.doGetTextList(accountSectionList);
    }

    public String getAccountPageLogo(){
        return elementUtils.doGetText(accountPageLogo);
    }

    public Boolean isLogoutExist(){
        return elementUtils.doIsDisplayed(logoutLink);
    }

}
