package lesson9.variation2;

import lesson5.MyWaiters;
import lesson9.ActionClass;
import lesson9.Assertions;
import lesson9.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MoveToAndSearchTest2 {
    @Test
    public void moveToSaerch() {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://foodex24.pl/ua");

        MyWaiters myWaiters = new MyWaiters(driver);
        Elements elements = new Elements(driver);
        ActionClass action = new ActionClass(driver);
        Assertions asserts = new Assertions(driver);

        elements.clickOnElementByXpath("//span[text()='Приховати']");
        action.moveToElementLocation("//span[text()='Риба та морепродукти']");
        elements.clickOnElementByXpath("//div[text()='Паста з морепродуктів']");
        myWaiters.waitTitleContainsText("Замовити Паста з морепродуктів");


        String input = "Халва";
        elements.sendKeysToElementWithXpath("//input[@type='search']", input);
        myWaiters.waitVisabilityOfWebElent(By.xpath("//div[@class='action-bar-search__suggestions']"));
        elements.clickOnElementByXpath("//button[@title='Пошук товарів']");
        myWaiters.waitVisabilityOfWebElent(By.xpath("//h1[@class='title title--size-h1 _text-center']"));
        asserts.equalsOfElementAndLabelText("//h1[@class='title title--size-h1 _text-center']/span[1]", "«" + input + "»");
        driver.quit();
    }
}
