package lesson9;

import lesson5.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements {
    private final WebDriver driver;
    private final MyWaiters waiters;

    public Elements(WebDriver driver){
        this.driver=driver;
        waiters = new MyWaiters(driver);
    }

    public WebElement findSingleElement(By by){
        try {
            waiters.waitVisabilityOfWebElent(by);
            return driver.findElement(by);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return null;
    }

    public WebElement findElementByXpath(String xpath){
        try {
            waiters.waitVisabilityOfWebElent(By.xpath(xpath));
            return driver.findElement(By.xpath(xpath));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean isElementDisplayed(String xpath){
        return findElementByXpath(xpath).isDisplayed();
    }
    public String getTextFromElementXpath(String xpath){
        return  findElementByXpath(xpath).getText();
    }
    public void clickOnElementByXpath(String xpath){
        findElementByXpath(xpath).click();
    }
    public void sendKeysToElementWithXpath(String xpath,String text){
        findElementByXpath(xpath).sendKeys(text);
    }
}
