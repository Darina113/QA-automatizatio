package HW9;
//Открыть сайт https://uhomki.com.ua/ru/.  Проверить, что после нажатия кнопки “ Оплата и доставка” открывается страница с нужной ссылкой.
//А именно https://uhomki.com.ua/ru/oplata-i-dostavka/.

import HW8.OwnWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Task2 {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));//неявные ожидания загрузки страницы
        driver.get("https://uhomki.com.ua/ru/");
        driver.manage().window().maximize(); //вызов большого окна
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void mustUrl() {
        OwnWaiters exempClassa = new OwnWaiters(driver);
        WebElement payANDdel = driver.findElement(By.xpath("//span[3]/a[text()='Оплата и доставка']"));
        exempClassa.waitVisibilityOfElementLocatedReturn(By.xpath("//span[3]/a[text()='Оплата и доставка']"));
        payANDdel.click();
        String nameUrl="https://uhomki.com.ua/ru/oplata-i-dostavka/";
        //System.out.println(driver.getCurrentUrl());
        assertEquals(driver.getCurrentUrl(),nameUrl,"Ссылка не соответсвует необходимой");
    }
}
