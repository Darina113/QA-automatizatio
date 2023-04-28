package lesson5;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class MyWaiters {
    private final WebDriver driver;

    public MyWaiters(WebDriver driver){
        this.driver = driver;
    }

    private static final long EXPLICITY_WAIT=20L;

    private FluentWait<WebDriver> fluentWait(Long duration){
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);
    }
    private void waitForFunction(Function function,Long timeout){
        FluentWait<WebDriver> wait = fluentWait(timeout);
        wait.until(function);
    }

    public void waitForVisabilityOfElement(By by){
        waitForFunction(ExpectedConditions.visibilityOfElementLocated(by),EXPLICITY_WAIT);
    }

    public WebElement waitForVisabilityOfElementReturn(By by){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForFrameAndSwitchToIt(By by){
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by),EXPLICITY_WAIT);
    }

    public Alert waitForAlertAndSwitchToIt(){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.alertIsPresent());
    }

    public void waitElementToBeClickable(By by){
        waitForFunction(ExpectedConditions.elementToBeClickable(by),EXPLICITY_WAIT);
    }
    public void waitElementToBeClickable(WebElement element){
        waitForFunction(ExpectedConditions.elementToBeClickable(element),EXPLICITY_WAIT);
    }
    public void waitElementToBeSelected(By by){
        waitForFunction(ExpectedConditions.elementToBeSelected(by),EXPLICITY_WAIT);
    }
    public void waitElementToBeSelected(WebElement element){
        waitForFunction(ExpectedConditions.elementToBeSelected(element),EXPLICITY_WAIT);
    }
    public void waitElementStateToBe(WebElement element, boolean boo){
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(element,boo),EXPLICITY_WAIT);
    }
    public void waitVisabilityOfWebElent(WebElement element){
        waitForFunction(ExpectedConditions.visibilityOf(element),EXPLICITY_WAIT);
    }
    public void waitVisabilityOfWebElent(By by){
        waitForFunction(ExpectedConditions.visibilityOf(driver.findElement(by)),EXPLICITY_WAIT);
    }
    public WebElement waitVisabilityOfWebElentReturn(WebElement element){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement waitVisabilityOfWebElentReturn(By by){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }



}
