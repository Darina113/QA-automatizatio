package HW10;

import HW8.OwnWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Task5 {
    WebDriver driver;

    @BeforeClass
//перед запуском всего класса будет запускаться сначала этот метод BeforeClass,после остальные  методы (тесты) будут происходить
    public void openDriver(){
        ChromeOptions options = new ChromeOptions(); //экземпдяр класса Хром
        options.addArguments("--disable-notifications"); //просим закрыть модальное окно
        driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver", "/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));//неявные ожидания загрузки страницы
        driver.get("https://www.foxtrot.com.ua/");
        driver.manage().window().maximize(); //вызов большого окна
        OwnWaiters exempClassa = new OwnWaiters(driver);
        WebElement locationButton=exempClassa.waitVisibilityOfElementLocatedReturn(By.xpath("//div[@class='popup__title first-visit']"));
        WebElement acceptLocation=exempClassa.waitVisibilityOfElementLocatedReturn(By.xpath("//a[@class='button user-confirm-location-button']"));
        acceptLocation.click();

    }
    @AfterClass//после прохождения всех методов(тестов) сработает этот метод AfterClass
    public void closeDriver() {
        driver.quit();
    }
    @Test
    @Parameters({"input"})//передали параметр, а саму настройку делаем в NG файле testngParametersHomeHW10.xml
    public void searchLineTest(String searchParams)throws ZeroLocator{
        OwnWaiters exempClassa = new OwnWaiters(driver);
        WebElement searchLine=exempClassa.waitVisibilityOfElementLocatedReturn(By.xpath("//input[@type='search']"));
        String searchText = searchParams;//применяем параметры
        searchLine.sendKeys(searchText);
        searchLine.sendKeys(Keys.ENTER);
        WebElement resultLine=exempClassa.waitPresenceOfElementLocatedReturn(By.xpath("//h1[text()]"));
        System.out.println(resultLine.getText());
        String resultSearch=resultLine.getText().replace("Знайдено по запиту «","").replace("»","");
        assertEquals(resultSearch,searchText);


        /*
            WebElement resultLine2=exempClassa.waitPresenceOfElementLocatedReturn(By.xpath("//div[@class='search-page__box-title']"));
            String resultSearch=resultLine2.getText().replace("За запитом «","").replace("» нічого не знайдено","");
            assertEquals(resultSearch,searchResult);
        }*/

    }

}
