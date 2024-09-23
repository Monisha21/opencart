package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverFactory {

    WebDriver driver;
    Properties properties;

    public Properties initializeProperties(){
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("D:\\Documents\\Mani Moni\\Monisha\\Automation\\opencart\\src\\resources\\config\\config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.getMessage();
        }
        return properties;
    }

    public WebDriver initializeDriver(Properties prop){

        String browserName = prop.getProperty("browser");
        switch (browserName){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Browsername entered is invalid " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
        return driver;
    }

}
