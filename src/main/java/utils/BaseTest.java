package utils;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;
import pages.MyAccountPage;

import java.util.Properties;

public class BaseTest {

    DriverFactory driverFactory;
    public WebDriver driver;
    public Properties prop;

    public LoginPage loginPage;
    public MyAccountPage myAccountPage;

    @BeforeTest
    public void setUp(){
        driverFactory= new DriverFactory();
        prop = driverFactory.initializeProperties();
        driver = driverFactory.initializeDriver(prop);
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
