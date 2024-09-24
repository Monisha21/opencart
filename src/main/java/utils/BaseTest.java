package utils;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;

import java.util.Properties;

public class BaseTest {

    DriverFactory driverFactory;
    private WebDriver driver;
    Properties prop;
    public LoginPage loginPage;

    @BeforeTest
    public void setUp(){
        prop = driverFactory.initializeProperties();
        driver = driverFactory.initializeDriver(prop);
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
