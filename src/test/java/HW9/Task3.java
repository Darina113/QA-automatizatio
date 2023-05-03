package HW9;

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

import static org.testng.Assert.assertEquals;

//Открыть сайт https://uhomki.com.ua/ru/.
// Ввести в строку поиска слово “смесь” и совершить поиск.
// Проверить что слово “смесь” присутствует в сообщении о результатах поиска.
// После ввести в строку поиска слово “спесь” и совершить поиск.
// Проверить что слово “спесь” присутствует в сообщении о результатах поиска.
// После ввести в строку поиска слово “ересь” и совершить поиск.
// Проверить что слово “ересь” присутствует в сообщении о результатах поиска.
public class Task3 {
    WebDriver driver = new ChromeDriver();
    @BeforeClass
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));//неявные ожидания загрузки страницы
        driver.get("https://uhomki.com.ua/ru/");
        driver.manage().window().maximize(); //вызов большого окна
    }
   /* @AfterClass
    public void closeDriver() {
        driver.quit();
    }*/
    @Test
    public void sootvResult(){
        OwnWaiters exempClassa = new OwnWaiters(driver);
        Actions actions = new Actions(driver);
        WebElement search= driver.findElement(By.xpath("//input[@class='search__input']"));
        exempClassa.waitVisibilityOfElementLocatedReturn(By.xpath("//input[@class='search__input']"));
        String smes="смесь";
        search.sendKeys(smes);
        search.submit();
        WebElement resSmes= driver.findElement(By.xpath("//h1[@id='j-catalog-header']"));
        exempClassa.waitVisibilityOfElementLocatedReturn(By.xpath("//h1[@id='j-catalog-header']"));
        System.out.println(resSmes.getText());
        String resTextSmes=resSmes.getText().replace("Результаты поиска ","");
        assertEquals(resTextSmes,smes);

    }
}
