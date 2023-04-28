package lesson4.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");
        System.out.println("Икс поиска");
        System.out.println(driver.findElement(By.xpath("//input[@name='q']")).getLocation().x);
        System.out.println("Y поиска");
        System.out.println(driver.findElement(By.xpath("//input[@name='q']")).getLocation().y);
        System.out.println("==========================");
        System.out.println("Икс хитов");
        System.out.println(driver.findElement(By.xpath("//span[text()='Хиты продаж']")).getLocation().x);
        System.out.println("Y хитов");
        System.out.println(driver.findElement(By.xpath("//span[text()='Хиты продаж']")).getLocation().y);
        driver.quit();
    }
}
