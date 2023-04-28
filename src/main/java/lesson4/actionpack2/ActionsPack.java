package lesson4.actionpack2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class ActionsPack {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        Set<String> firstSet = driver.getWindowHandles();
        actions.moveToElement(driver.findElement
                (By.xpath("//div[@class='columned block block-4-12']//a[text()='APPLICATION PROCESS']")))
                .keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
        Set<String> secondSet = driver.getWindowHandles();//keyDown - нажал и держу клаву Control,keyUp - отпускаем клаву Control
        secondSet.removeAll(firstSet);
        //String window = secondSet.iterator().next();
        driver.switchTo().window(secondSet.iterator().next());//перекл на новое окно помещаем в него secondSet и делаем iterator и переходим в next
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.quit();
    }
}
