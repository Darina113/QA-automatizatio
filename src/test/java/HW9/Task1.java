package HW9;
//Открыть сайт https://dan-it.com.ua/uk/ . На этой странице открыть в новых вкладках ссылки “Java”, “Quality Assurance (QA)”, “FrontEnd”.
//Прописать тест, проверяющий количество открытых окон. Он должен проходить, если количество открытых окон равно 4.

import HW8.OwnWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class Task1 {
    WebDriver driver = new ChromeDriver();
    @BeforeClass//перед запуском всего класса будет запускаться сначала этот метод BeforeClass,после остальные  методы (тесты) будут происходить
    public void openDriver(){
        System.setProperty("webdriver.chrome.driver", "/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));//неявные ожидания загрузки страницы
        driver.get("https://dan-it.com.ua/uk/ ");
        driver.manage().window().maximize(); //вызов большого окна
    }
    @AfterClass//после прохождения всех методов(тестов) сработает этот метод AfterClass
    public void closeDriver() {
        driver.quit();
    }
     @Test
    public void fourthWindow(){
         OwnWaiters exempClassa=new OwnWaiters(driver);
         Actions actions = new Actions(driver);
         WebElement dorosli= driver.findElement(By.xpath("//a[text()='Для дорослих']"));
         exempClassa.waitVisibilityOfElementLocatedReturn(By.xpath("//a[text()='Для дорослих']"));
         actions.moveToElement(dorosli).perform();
         actions.moveToElement(driver.findElement(By.xpath("//a[text()='FrontEnd']"))).keyDown(Keys.COMMAND).click().keyUp(Keys.COMMAND).build().perform();
         actions.moveToElement(driver.findElement(By.xpath("//a[text()='Java']"))).keyDown(Keys.COMMAND).click().keyUp(Keys.COMMAND).build().perform();
         actions.moveToElement(driver.findElement(By.xpath("//a[text()='Quality Assurance (QA)']"))).keyDown(Keys.COMMAND).click().keyUp(Keys.COMMAND).build().perform();
         Set<String> count = driver.getWindowHandles();//сделали массив из дискрипторов
         Iterator<String> i = count.iterator(); //разделили их
         assertTrue(count.size()==4,"Количество открытых окон != 4");

     }
}
