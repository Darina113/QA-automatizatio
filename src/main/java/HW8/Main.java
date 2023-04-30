package HW8;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.openqa.selenium.Keys.ENTER;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //вызов большого окна
        //1 действие
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));//неявные ожидания загрузки страницы
        driver.get("https://www.google.com/search");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));//в его конструктор требует положить экземпляр драйвера (driver), и его ожидания (Duration.ofSeconds)
        OwnWaiters proba=new OwnWaiters(driver);
        WebElement search= driver.findElement(By.xpath("//textarea[@id='APjFqb']")); //кнопка поиска
        search.sendKeys("https://www.guinnessworldrecords.com/account/register?");
        String str="https://www.guinnessworldrecords.com/account/register?";
        //visibilityOfElementLocated(), frameToBeAvailableAndSwitchToIt(), alertIsPresent()
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='APjFqb']")));

        //В ЧЕМ РАЗНИЦА ЭТИХ ДВУХ ЭЛЕМЕНТОВ?  один без возвращаемого значения, второй с
        proba.waitVisibilityOfElementLocatedReturn(By.xpath("//textarea[@id='APjFqb']"));
        proba.waitVisibilityOfElementLocated(By.xpath("//textarea[@id='APjFqb']"));



        //presenceOfElementLocated() - ожидает появление элемента (работает только по локатору)
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@id='APjFqb']")));

        //textToBePresentInElementValue - ожидает появление текста в элементе который надо вводить в него находящийся по заданному локатору
        wait.until(ExpectedConditions.textToBePresentInElementValue(search,"https://www.guinnessworldrecords.com/account/register?"));
        wait.until(ExpectedConditions.textToBePresentInElementValue(search,str));
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//textarea[@id='APjFqb']"),str));
        wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//textarea[@id='APjFqb']"),"https://www.guinnessworldrecords.com/account/register?"));
        proba.waitTextToBePresentInElementValue(search,str);
        proba.waitTextToBePresentInElementValue(By.xpath("//textarea[@id='APjFqb']"),"https://www.guinnessworldrecords.com/account/register?");
        proba.waitTextToBePresentInElementValue(search,"https://www.guinnessworldrecords.com/account/register?");
        proba.waitTextToBePresentInElementValue(By.xpath("//textarea[@id='APjFqb']"),str);

        //invisibilityOf() - ожидание видимости элемента (работает только по Вебэлементу)
        wait.until(ExpectedConditions.invisibilityOf(search));

        //titleContains() - ожидание что в названии страницы находится указанный текст (работает только со стринг)
        wait.until(ExpectedConditions.titleContains("text"));
        wait.until(ExpectedConditions.titleContains(str));

        //titleIs() - ожидание указанного названия страницы (работает только со стринг)
        wait.until(ExpectedConditions.titleIs("text"));
        wait.until(ExpectedConditions.titleIs(str));

        //elementToBeClickable() - ожидание кликабельности элемента
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='APjFqb']")));
        wait.until(ExpectedConditions.elementToBeClickable(search));

        //elementToBeSelected() - ожидание чтобы элемент был выбран
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//textarea[@id='APjFqb']")));
        wait.until(ExpectedConditions.elementToBeSelected(search));

        //elementSelectionStateToBe() - ожидание от элемента быть или не быть выбранным
        wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//textarea[@id='APjFqb']"),true));
        wait.until(ExpectedConditions.elementSelectionStateToBe(search,true));

        //visibilityOfElementLocated() - ожидание видимости элемента (работает только по локатору)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='APjFqb']")));


        //frameToBeAvailableAndSwitchToIt() - Ожидание доступности фрейма и переключение на него.
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//textarea[@id='APjFqb']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(search));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframe"));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(10));

        //alertIsPresent() - Ожидание появления алерта.
        wait.until(ExpectedConditions.alertIsPresent());

    }
}
