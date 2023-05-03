package HW9;
//Открыть сайт http://only-testing-blog.blogspot.com/2014/01/textbox.html?.
//Написать тест, проверяющий содержит ли модальное окно, которое появляется после нажатия на кнопку “Show Me Alert” необходимый текст.

import HW8.OwnWaiters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import static org.testng.Assert.*;

public class Task5 {
    WebDriver driver = new ChromeDriver();
    @BeforeClass
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));//неявные ожидания загрузки страницы
        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");
        driver.manage().window().maximize(); //вызов большого окна
    }
    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
    @Test
    public void showAlert(){
        //input[@onclick='myFunction1()']
        OwnWaiters exempClassa = new OwnWaiters(driver);
        Actions actions = new Actions(driver);
        WebElement showMeAlert= driver.findElement(By.xpath("//input[@onclick='myFunction1()']"));
        actions.moveToElement(showMeAlert).click().perform();
        exempClassa.waitAlertIsPresent();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        assertEquals(alert.getText(),"Hi.. This is alert message!");
        alert.accept();

    }
}
