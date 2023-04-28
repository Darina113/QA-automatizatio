package lesson4.addSmth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Keys {
    static WebDriver driver;

    static void sendKeysAndClick(By by, String text){
        WebElement element = driver.findElement(by);
        element.sendKeys(text);
        element.submit();
    }
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
        search.sendKeys("Найди меня");
        search.submit();
        driver.get("https://uhomki.com.ua/ru/");
        Thread.sleep(2000);
        WebElement search2 = driver.findElement(By.xpath("//input[@name='q']"));
        Actions actions = new Actions(driver);
        actions.sendKeys(search2,"Найди себя").sendKeys(org.openqa.selenium.Keys.ENTER)
                .build().perform();
        Thread.sleep(7000);

        driver.get("https://uhomki.com.ua/ru/");
        Thread.sleep(2000);
        sendKeysAndClick(By.xpath("//input[@name='q']"),"Просто текст");
        Thread.sleep(3000);
        driver.quit();
    }
}
