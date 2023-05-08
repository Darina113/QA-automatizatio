package lesson10;

import lesson5.MyWaiters;
import lesson9.ActionClass;
import lesson9.Assertions;
import lesson9.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomeworkEx {

    @Test(dataProvider ="searchProvider")
    public void searchFox(String inputText) {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);

        MyWaiters myWaiters = new MyWaiters(driver);
        Elements elements = new Elements(driver);
        ActionClass action = new ActionClass(driver);
        Assertions asserts = new Assertions(driver);

        driver.manage().window().maximize();
        driver.get("https://www.foxtrot.com.ua/");

        String input =inputText;
        elements.sendKeysToElementWithXpath("//input[@type='search']", input);
        elements.clickOnElementByXpath("//input[@value='Найти']");
        myWaiters.waitTitleContainsText("Найдено по запросу");
        myWaiters.waitVisabilityOfWebElent(By.tagName("h1"));
        if ((driver.findElement(By.tagName("h1"))).getText().contains("Найдено по запросу")) {
            String resultOfReach = (driver.findElement(By.tagName("h1")))
                    .getText().replace("Найдено по запросу ", "");
            //asserts.equalsOfStrings(resultOfReach, "«"+input+"»" );
        } else if((driver.findElement(By.tagName("h1"))).getText().contains("Результаты поиска")){
            String resultOfReach = (driver.findElement(By.xpath("//div[@class='search-page__box-title']/label")))
                    .getText();
            //asserts.equalsOfStrings(resultOfReach, "«"+input+"»" );
        }
        driver.quit();
    }

    /*@DataProvider(name="searchProvider")
    public Object[] searchObjects(){
        return new Object[]{
                "input","смысл","машина"
        };
    }*/
}
