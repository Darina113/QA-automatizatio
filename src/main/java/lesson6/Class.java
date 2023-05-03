package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/koshki/1074/");

        driver.findElement(By.className("search__input")).sendKeys("Хорек");
        Thread.sleep(2000);
        driver.findElement(By.className("search__input")).sendKeys(Keys.ENTER);
        driver.findElement(By.className("catalogCard-title")).click();
        driver.findElement(By.className("comparison-button__text")).click();
        driver.findElement(By.className("search__input")).sendKeys("Медведь");
        Thread.sleep(2000);
        driver.findElement(By.className("search__input")).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@href='/ru/belyy-medved-6kh5kh6sm/14684/']")).click();
    }
    }

