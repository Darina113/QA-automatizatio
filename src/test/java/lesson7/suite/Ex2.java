package lesson7.suite;

import lesson5.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class Ex2 {
    WebDriver driver;

    @BeforeClass
    public void driverInitialisation() {
        System.setProperty("webdriver.chrome.driver", "/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/");
        new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//a[@aria-label='dismiss cookie message']")).click();
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void checkWebPageTitle() {
        driver.get("https://klopotenko.com/");
        String pageTitle = "Євген Клопотенко - Кулінарні рецепти від Євгена Клопотенка";
        String pageTitle2 = "Євген Клопотенкwо - Кулінарні рецепти від Євгена Клопотенка";
        String partOfTitle = "Євген Клопотенко";
        new MyWaiters(driver).waitTitleContainsText(partOfTitle);
        assertTrue(driver.getTitle().equals(pageTitle), "Название не соответствует ожидаемому");

        assertFalse(driver.getTitle().equals(pageTitle2), "Название соответствует ожидаемому");

        assertEquals(driver.getTitle(), pageTitle, "Название не соответствует ожидаемому.\n" +
                "Я ожидал " + pageTitle + " а получил " + driver.getTitle());

        assertNotEquals(driver.getTitle(), pageTitle2, "Название не соответствует ожидаемому.\n" +
                "Я ожидал " + pageTitle2 + " а получил " + driver.getTitle());
    }


    @Test
    public void functionOfChecBox() throws InterruptedException {
        driver.get("https://klopotenko.com/");
        new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//span[text()='ВХІД']")).click();
        new MyWaiters(driver).waitTitleContainsText("Вхід - Klopotenko");
        assertEquals(driver.getTitle(), "Вхід - Klopotenko");
        WebElement unclicked = new MyWaiters(driver).waitPresenceOfElementReturn
                (By.xpath("//i[@class='um-icon-android-checkbox-outline-blank']"));
        assertTrue(unclicked.isDisplayed());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,200)");

        unclicked.click();

        assertTrue(
                new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//i[@class='um-icon-android-checkbox-outline']"))
                        .isDisplayed()
        );

        driver.findElement(By.xpath("//i[@class='um-icon-android-checkbox-outline']")).click();

        assertTrue(
                new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//i[@class='um-icon-android-checkbox-outline-blank']"))
                        .isDisplayed()
        );
    }

    @Test
    public void countOfIngridients() {
        driver.get("https://klopotenko.com/sparzha-z-sousom-beshamel/");
        assertEquals(driver.findElement(By.xpath("//h4[text()='Для спаржі:']")).getText(),
                "Для спаржі:");
        assertEquals(driver.findElement(By.xpath("//h4[text()='Для бешамель:']")).getText(),
                "Для бешамель:");

        List<WebElement> sparza = driver.findElements(By.xpath("//h4[text()='Для спаржі:']/following-sibling::div/div//label"));
        assertTrue(sparza.size() == 4, "Кол-во ингридиентов не совпадает с ожиданием");

        List<WebElement> beshamel = driver.findElements(By.xpath("//h4[text()='Для бешамель:']/following-sibling::div/div//label"));
        assertTrue(beshamel.size() == 5, "Кол-во ингридиентов не совпадает с ожиданием");
        String[] labelsSparza = {"500 г спаржі", "30 г вершкового масла", "сік чверті лимона", "сіль за смаком"};
        for (int i = 0; i < sparza.size(); i++) {
            assertEquals(sparza.get(i).getText(), labelsSparza[i]);
        }

        String[] labelsBeshamel = {"30 г вершкового масла", "30 г борошна пшеничного", "300 мл молока", "за смаком сіль", "дрібка мускатного горіха"};
        for (int i = 0; i < beshamel.size(); i++) {
            assertEquals(beshamel.get(i).getText(), labelsBeshamel[i]);
        }
    }
}
