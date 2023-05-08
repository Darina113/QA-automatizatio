package lesson9;

import lesson5.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MoveToAndSearchTest {
    @Test
    public void moveToSaerch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        MyWaiters myWaiters = new MyWaiters(driver);
        driver.manage().window().maximize();
        driver.get("https://foodex24.pl/ua");
        myWaiters.waitVisabilityOfWebElentReturn(By.xpath("//span[text()='Приховати']")).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(myWaiters.waitPresenceOfElementReturn(By.xpath("//span[text()='Риба та морепродукти']"))).perform();
        myWaiters.waitVisabilityOfWebElentReturn(By.xpath("//div[text()='Паста з морепродуктів']")).click();
        myWaiters.waitTitleContainsText("Замовити Паста з морепродуктів");



        WebElement search = myWaiters.waitVisabilityOfWebElentReturn(By.xpath("//input[@type='search']"));
        String input = "Халва";
        search.sendKeys(input);
        myWaiters.waitVisabilityOfWebElent(By.xpath("//div[@class='action-bar-search__suggestions']"));
        myWaiters.waitPresenceOfElementReturn(By.xpath("//button[@title='Пошук товарів']")).click();
        myWaiters.waitVisabilityOfWebElent(By.xpath("//h1[@class='title title--size-h1 _text-center']"));
        assertEquals(driver.findElement(By.xpath("//h1[@class='title title--size-h1 _text-center']/span[1]")).getText(),
                "«"+input+"»");
        driver.quit();
    }
}
