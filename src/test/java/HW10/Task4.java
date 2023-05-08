package HW10;

import HW8.OwnWaiters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class Task4 {
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
    @Test(dataProvider = "search")
    public void searchLineTest(String searchParams,String searchResult)throws ZeroLocator{
        OwnWaiters exempClassa = new OwnWaiters(driver);
        WebElement searchLine=exempClassa.waitVisibilityOfElementLocatedReturn(By.xpath("//input[@type='search']"));
        searchLine.sendKeys(searchParams);//сюда передастся по превому эл из каждого массива (машина,input,смысл)
        searchLine.sendKeys(Keys.ENTER);
        WebElement resultLine=exempClassa.waitPresenceOfElementLocatedReturn(By.xpath("//h1[text()]"));
        System.out.println(resultLine.getText());

        try {
            if (resultLine.getText()=="Результати пошуку"){
                throw new ZeroLocator();
            }

        }catch (ZeroLocator a){
            resultLine=exempClassa.waitPresenceOfElementLocatedReturn(By.xpath("//div[@class='search-page__box-title']"));
            String resultSearch=resultLine.getText().replace("За запитом «","").replace("» нічого не знайдено","");
            return;
        }
        String resultSearch=resultLine.getText().replace("Знайдено по запиту «","").replace("»","");
        assertEquals(resultSearch,searchResult);

    }
    @DataProvider(name = "search")
    public Object[][] searchObj() {//Object[][]- многомерный массив
        return new Object[][]{
                {"машина","машина"}, {"input","input"}, {"смысл","смысл"}//{"машина","машина"}- 1 массив, {"input","input"}-2 массив, {"смысл","смысл"}- 3 массив
        };
    }
}
