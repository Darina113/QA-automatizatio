package lesson5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WyWaitersTests {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

        //visibilityOfElementLocated(), frameToBeAvailableAndSwitchToIt(), alertIsPresent()
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));//в его конструктор требует положить экземпляр драйвера (driver), и его ожидания (Duration.ofSeconds)
        MyWaiters waiters = new MyWaiters(driver); //создаем экземпляр класса (который создали под названием MyWaiters и в его конструктор помещаем экземпляр нашего драйвера

        //1 вариант записи
        WebElement acceptCoockies = waiters.waitForVisabilityOfElementReturn(By.id("accept-choices"));//используем уже наш метод
        waiters.waitVisabilityOfWebElentReturn(By.xpath("//iframe[@id='iframeResult']"));
        acceptCoockies.click();

        //2 вариант записи
        WebElement acceptCoockies2 = new MyWaiters(driver).waitForVisabilityOfElementReturn(By.id("accept-choices"));
        acceptCoockies2.click();

        waiters.waitForFrameAndSwitchToIt(By.xpath("//iframe[@id='iframeResult']"));//используем наш же метод
        driver.findElement(By.xpath("//button[text()='Try it']")).click();

        Alert alert = waiters.waitForAlertAndSwitchToIt();
        System.out.println(alert.getText());
        alert.accept();
        System.out.println(driver.getTitle());
        driver.quit();

        //мои пробы
        //visibilityOfElementLocated - работает только по локатору
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='iframeResult']"))); //стандартный метод
        waiters.waitForVisabilityOfElement(By.xpath("//iframe[@id='iframeResult']"));// наш метод (ничего не возвращает)
        waiters.waitForVisabilityOfElementReturn(By.xpath("//iframe[@id='iframeResult']"));//наш метод который возвращает элемент

        //frameToBeAvailableAndSwitchToIt - работает по 5 видам
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(acceptCoockies2));//стандартный метод
        waiters.waitForFrameAndSwitchToIt(By.xpath("//iframe[@id='iframeResult']"));// наш метод (ничего не возвращает) и написали только по ву
        waiters.waitForFrameAndSwitchToIt(acceptCoockies2);// наш метод (ничего не возвращает) и написали только по ву




        //elementToBeClickable(), elementToBeSelected(), elementSelectionStateToBe()
        //"https://www.guinnessworldrecords.com/Account/Login");
        /*
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        MyWaiters myWaiters = new MyWaiters(driver);
        WebElement accept = myWaiters.waitForVisabilityOfElementReturn(By.id("ez-accept-all"));//используем наш метод
        accept.click();
        WebElement pass = myWaiters.waitForVisabilityOfElementReturn(By.xpath("//input[ @id='Password']"));
        WebElement userName = myWaiters.waitForVisabilityOfElementReturn(By.xpath("//input[ @id='Username']"));
        WebElement checkBox = myWaiters.waitForVisabilityOfElementReturn(By.xpath("//input[ @id='RememberMe']"));
        myWaiters.waitElementToBeClickable(checkBox);
        myWaiters.waitElementToBeClickable(By.tagName("h1"));
        myWaiters.waitElementToBeClickable(checkBox);
        myWaiters.waitElementToBeSelected(checkBox);
        pass.sendKeys("111111111");
        myWaiters.waitElementStateToBe(checkBox, false);
        userName.sendKeys("Just Text");
         */


        //presenceOfElementLocated(), textToBePresentInElementValue(), invisibilityOf(),
        /*
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
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
        driver.findElement(By.xpath("//div[@class='header__wrap']//a[text()=' Блог ']")).click();

         */
    }
}
