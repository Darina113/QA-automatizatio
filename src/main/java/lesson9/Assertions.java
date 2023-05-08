package lesson9;

import lesson5.MyWaiters;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Assertions {
    private final Elements elements;
    private final ActionClass actions;
    private final WebDriver driver;
    private final MyWaiters waiters;

    public Assertions(WebDriver driver) {
        this.driver = driver;
        elements = new Elements(driver);
        actions = new ActionClass(driver);
        waiters = new MyWaiters(driver);
    }

    public void elementIsDisplayed(String xpath){
        assertTrue(elements.isElementDisplayed(xpath), "Эдемент не отображается, хотя должен был");
    }
    public void equalsOfElementAndLabelText(String xpathOfElement, String expectedString){
        assertEquals(elements.getTextFromElementXpath(xpathOfElement),expectedString,
                "Я ожидал получить "+expectedString+". А получил "+ elements.getTextFromElementXpath(xpathOfElement));
    }
}
