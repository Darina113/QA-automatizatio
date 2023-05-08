package lesson9.ex;

import lesson5.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Homiak {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        MyWaiters myWaiters = new MyWaiters(driver);
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='поиск товаров']"));
        String input = "семь";
        element.sendKeys(input);
        element.submit();
        Thread.sleep(3000);
        String result = driver.findElement(By.tagName("h1")).getText();
        String resultUpdate = result.replace("Результаты поиска ","");
        //«семь»
        assertTrue(resultUpdate.equals("«"+input+"»"));
        Thread.sleep(3000);
        WebElement element2 = driver.findElement(By.xpath("//input[@placeholder='поиск товаров']"));
        String input2 = "семццць";
        element2.clear();
        Thread.sleep(1000);
        element2.sendKeys(input2);
        element2.submit();
        Thread.sleep(3000);
        String result2 = driver.findElement(By.tagName("h1")).getText();
        String resultUpdate2 = result2.replace("Результаты поиска ","");
        //«семь»
        assertTrue(resultUpdate2.equals("«"+input2+"»"));

        Thread.sleep(3000);
        WebElement element1 = driver.findElement(By.xpath("//input[@placeholder='поиск товаров']"));
        String input1 = "ересь";
        element1.clear();
        Thread.sleep(1000);
        element1.sendKeys(input1);
        element1.submit();
        Thread.sleep(3000);
        String result1 = driver.findElement(By.tagName("h1")).getText();
        String resultUpdate1 = result1.replace("Результаты поиска ","");
        //«семь»
        assertTrue(resultUpdate1.equals("«"+input1+"»"));

        driver.quit();
    }
}

