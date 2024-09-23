package utils;//package utils;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//public class BrowserUtils {
//
//    WebDriver driver;
//
//    public WebDriver initializeDriver(String browserName){
//        switch (browserName){
//            case "chrome":
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//                break;
//            case "firefox":
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                break;
//            case "edge":
//                WebDriverManager.edgedriver().setup();
//                driver = new EdgeDriver();
//                break;
//            default:
//                System.out.println("Browsername entered is invalid " + browserName);
//        }
//        return driver;
//    }
//
//    public void launchUrl(String applicationUrl){
//        driver.get(applicationUrl);
//    }
//
//    public String getTitle(){
//        return driver.getTitle();
//    }
//
//    public String getPageUrl(){
//        return driver.getCurrentUrl();
//    }
//
//    public void maximizeWindow(){
//        driver.manage().window().maximize();
//    }
//
//    public void closeBrowser(){
//        driver.close();
//    }
//
//    public void quitBrowser(){
//        driver.quit();
//    }
//
//}
