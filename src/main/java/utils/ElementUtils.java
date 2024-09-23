package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementUtils {

    private WebDriver driver;

    public ElementUtils(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }

    public void doSendKeys(By locator, String value){
        getElement(locator).sendKeys(value);
    }

    public String doGetText(By locator){
        return getElement(locator).getText();
    }

    public List<String> doGetTextList(By locator){
        List<WebElement> elementLists = getElements(locator);
        List<String> getTextList = new ArrayList<String>();
        for(WebElement e : elementLists){
            if(!e.getText().isEmpty()){
                getTextList.add(e.getText());
            }
        }
        return getTextList;
    }

    public Boolean doIsDisplayed(By locator){
        return getElement(locator).isDisplayed();
    }

    public Boolean doIsEnabled(By locator){
        return getElement(locator).isEnabled();
    }

    public void doClick(By locator){
        driver.findElement(locator).click();
    }

    /**
     * DropDown methods
     */
    public void selectByIndexDropDown(By locator, int index){
        Select select = new Select(getElement(locator));
        select.selectByIndex(index);
    }

    public void selectByValueDropDown(By locator, String valueAttribute){
        Select select = new Select(getElement(locator));
        select.selectByValue(valueAttribute);
    }

    public void selectByVisibleTextDropDown(By locator, String visibleText){
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(visibleText);
    }

    public void selectDropDownAllOptions(By locator, String value){
        Select select = new Select(getElement(locator));
        List<WebElement> getAllOptions = select.getOptions();
        for(WebElement e : getAllOptions){
            if(e.getText().equals(value)){
                e.click();
                break;
            }
        }
    }

    //Without using Select class
    public void selectDropDownValue(By locator, String value){
        List<WebElement> allValues = getElements(locator);
        for(WebElement e : allValues){
            if(e.equals(value)){
                e.click();
                break;
            }
        }
    }

    public String waitForTitle(int timeout, String title){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.titleIs(title));
        return driver.getTitle();
    }

    public String getPageURL(){
        return driver.getCurrentUrl();
    }
}