package lesson9;

import lesson5.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DragNDropTest {
    @Test
    public void dragNDrop(){
        System.setProperty("webdriver.chrome.driver", "/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        WebDriver driver = new ChromeDriver();
        MyWaiters myWaiters = new MyWaiters(driver);
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        myWaiters.waitPresenceOfElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        myWaiters.waitForFrameAndSwitchToIt(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        myWaiters.waitPresenceOfElementReturn(By.xpath("//span[text()='Принять всё']")).click();

        WebElement first5000 = myWaiters.waitPresenceOfElementReturn(By.xpath("//li[@id='fourth'][1]/a"));
        WebElement first5000field = driver.findElement(By.xpath("//ol[@id='amt7']"));//сюда перетаскиваем

        WebElement second5000 = myWaiters.waitPresenceOfElementReturn(By.xpath("//li[@id='fourth'][2]/a"));
        WebElement second5000field = driver.findElement(By.xpath("//ol[@id='amt8']"));//сюда перетаскиваем

        WebElement bank = myWaiters.waitPresenceOfElementReturn(By.xpath("//li[@id='credit2']/a"));
        WebElement bankfield = driver.findElement(By.xpath("//ol[@id='bank']"));//сюда перетаскиваем

        WebElement sale = myWaiters.waitPresenceOfElementReturn(By.xpath("//li[@id='credit1']/a"));
        WebElement salefield = driver.findElement(By.xpath("//ol[@id='loan']"));//сюда перетаскиваем

        Actions actions = new Actions(driver);
        actions.dragAndDrop(first5000,first5000field).perform();
        actions.dragAndDrop(second5000,second5000field).perform();
        actions.dragAndDrop(bank,bankfield).perform();
        actions.dragAndDrop(sale,salefield).perform();

        WebElement perfect = myWaiters.waitPresenceOfElementReturn(By.xpath("//a[text()='Perfect!']"));
        assertTrue(perfect.isDisplayed());
        assertEquals(perfect.getText(),"Perfect!", "Я ожидал текст: Perfect!\nА получил текст: "+perfect.getText());
        driver.quit();
    }
}
