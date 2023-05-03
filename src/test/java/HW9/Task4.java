package HW9;
//Открыть сайт https://www.guinnessworldrecords.com/Account/Login.
// Написать тест, проверяющий что изначально чек-бокс “RememberMe” не выбран.
// Потом кликнуть на него и реализовать проверку того, что он выбран.
// После снова нажать на чек-бокс и проверить что он снова не выбран.

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Task4 {
    WebDriver driver = new ChromeDriver();
    @BeforeClass
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));//неявные ожидания загрузки страницы
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.manage().window().maximize(); //вызов большого окна
    }
    @AfterClass
    public void closeDriver() {
        driver.quit();
    }


}
