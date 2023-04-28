package lesson5;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Waiters {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //неявные ожидания
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //неявные ожидания загрузки страницы
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        //неявные ожидания отработки скриптов страницы
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

        //ЯВНЫЕ ОЖИДАНИЯ
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));*/

      /*  new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
        WebElement element =  new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
        */


        //visibilityOfElementLocated(), frameToBeAvailableAndSwitchToIt(), alertIsPresent()
        //"https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        //iframe[@id='iframeResult']
      /*  driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement acceptCoockies = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("accept-choices")));
        acceptCoockies.click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='iframeResult']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='iframeResult']")));
        driver.findElement(By.xpath("//button[text()='Try it']")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();
        System.out.println(driver.getTitle());
        driver.quit();*/


        //elementToBeClickable(), elementToBeSelected(), elementSelectionStateToBe()
        //"https://www.guinnessworldrecords.com/Account/Login");
        /*driver.get("https://www.guinnessworldrecords.com/Account/Login");
        //driver.findElement(By.id("ez-accept-all")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ez-accept-all")));
        accept.click();
        WebElement pass = driver.findElement(By.xpath("//input[ @id='Password']"));
        WebElement userName = driver.findElement(By.xpath("//input[ @id='Username']"));
        WebElement checkBox = driver.findElement(By.xpath("//input[ @id='RememberMe']"));

        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        System.out.println(driver.getTitle());
        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("h1")));
        wait.until(ExpectedConditions.elementToBeSelected(checkBox));
        pass.sendKeys("111111111");
        //wait.until(ExpectedConditions.elementToBeSelected(userName));
        wait.until(ExpectedConditions.elementSelectionStateToBe(checkBox,false));
        userName.sendKeys("Just Text");*/



        //presenceOfElementLocated(), textToBePresentInElementValue(), invisibilityOf(),
        //titleContains(), titleIs()
        //https://www.guinnessworldrecords.com/Account/Login");
        //span[text()='Please fill in the Email field.']
        /*driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ez-accept-all")));
        accept.click();
        WebElement pass = driver.findElement(By.xpath("//input[ @id='Password']"));
        WebElement userName = driver.findElement(By.xpath("//input[ @id='Username']"));
        WebElement checkBox = driver.findElement(By.xpath("//input[ @id='RememberMe']"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in the Email field.']")));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Please fill in the Email field.']")));
        wait.until(ExpectedConditions.textToBePresentInElementValue(userName,"text"));
        pass.sendKeys("1121212");
        userName.clear();
        userName.submit();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Please fill in the Email field.']")));
        driver.navigate().to("https://itstep.dp.ua/");

        wait.until(ExpectedConditions.titleIs("IT курси у Дніпрі з працевлаштуванням | Академія IT STEP"));
        wait.until(ExpectedConditions.titleContains("Академія IT STEP"));
        driver.findElement(By.xpath("//div[@class='header__wrap']//a[text()=' Блог ']")).click();*/


        //СВОБОДНЫЕ ОЖИДАНИЯ
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);

        driver.get("https://itstep.dp.ua/");
        fluentWait.until(ExpectedConditions.titleContains("Академія IT STEP"));
        driver.findElement(By.xpath("//div[@class='header__wrap']//a[text()=' Блог ']")).click();
    }
}
