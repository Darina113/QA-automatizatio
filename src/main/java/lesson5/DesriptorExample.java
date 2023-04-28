package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class DesriptorExample {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");
        String descrFirs = driver.getWindowHandle(); //получаем дискриптор первого окна
        Set<String> firsDescriptors = driver.getWindowHandles();
        Actions actions = new Actions(driver);

        WebElement pay = driver.findElement
                (By.xpath("//span[@class='site-menu__item']/a[text()='Оплата и доставка']"));
        WebElement contact = driver.findElement
                (By.xpath("//span[@class='site-menu__item']/a[text()='Контактная информация']"));

        actions.keyDown(Keys.CONTROL).click(pay).keyUp(Keys.CONTROL).build().perform();
        Set<String> secondDescriptors = driver.getWindowHandles();
        secondDescriptors.removeAll(firsDescriptors);
        String descrSecond = secondDescriptors.iterator().next();

        Set<String> secondDescriptorsAgain = driver.getWindowHandles();
        actions.keyDown(Keys.CONTROL).click(contact).keyUp(Keys.CONTROL).build().perform();
        Set<String> thirdDescriptors = driver.getWindowHandles();
        thirdDescriptors.removeAll(secondDescriptorsAgain);
        String descrThree = thirdDescriptors.iterator().next();
        //Ветеринарный центр
        driver.switchTo().window(descrThree);
        driver.findElement(By.xpath("//span[@class='site-menu__item']/a[text()='Ветеринарный центр']")).click();
        Thread.sleep(2000);

        driver.switchTo().window(descrSecond);
        driver.findElement(By.xpath("//span[@class='site-menu__item']/a[text()='Ветеринарный центр']")).click();
        Thread.sleep(2000);

        driver.switchTo().window(descrFirs);
        driver.findElement(By.xpath("//span[@class='site-menu__item']/a[text()='Ветеринарный центр']")).click();
        Thread.sleep(5000);
        driver.quit();

    }
}
