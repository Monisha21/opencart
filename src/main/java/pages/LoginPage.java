package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementUtils;

public class LoginPage {

    WebDriverWait webDriverWait;
    private WebDriver driver;
    private ElementUtils elementUtils;

    //locators
    private By emailAddress = By.id("input-email");
    private By passwordtxt = By.id("input-password");
    private By loginbtn = By.xpath("//button[@type='submit']");
    private By myAccountDrpDwn = By.xpath("//a[@class='dropdown-toggle']/span[contains(text(),'My Account')]");
    private By myAccountLoginDrpDwn = By.xpath("//a[@class='dropdown-item' and contains(text(),'Login')]/../..");

    //Constructors
    public LoginPage(WebDriver driver){
        this.driver = driver;
        elementUtils = new ElementUtils(driver);
    }

    //page functions
    public MyAccountPage login(String username, String password){
        elementUtils.doSendKeys(emailAddress, username);
        elementUtils.doSendKeys(passwordtxt,password);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getLoginPageTitle());
        elementUtils.doClick(loginbtn);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new MyAccountPage(driver);
    }

    public String getLoginPageTitle(){
        return elementUtils.waitForTitle(10, "Account Login");
    }

    public String getLoginPageURL(){
        return elementUtils.getPageURL();
    }

}
