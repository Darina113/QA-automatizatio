package lesson5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WyWaitersTests {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //visibilityOfElementLocated(), frameToBeAvailableAndSwitchToIt(), alertIsPresent()
        //"https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        //iframe[@id='iframeResult']
       /* driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        MyWaiters waiters = new MyWaiters(driver);
        WebElement acceptCoockies = waiters.waitForVisabilityOfElementReturn(By.id("accept-choices"));
        acceptCoockies.click();

        *//*WebElement acceptCoockies2 = new MyWaiters(driver).waitForVisabilityOfElementReturn(By.id("accept-choices"));
        acceptCoockies2.click()*//*;
        waiters.waitForFrameAndSwitchToIt(By.xpath("//iframe[@id='iframeResult']"));
        driver.findElement(By.xpath("//button[text()='Try it']")).click();

        Alert alert = waiters.waitForAlertAndSwitchToIt();
        System.out.println(alert.getText());
        alert.accept();
        System.out.println(driver.getTitle());
        driver.quit();*/


        //elementToBeClickable(), elementToBeSelected(), elementSelectionStateToBe()
        //"https://www.guinnessworldrecords.com/Account/Login");
        /*driver.get("https://www.guinnessworldrecords.com/Account/Login");
        MyWaiters myWaiters = new MyWaiters(driver);
        WebElement accept = myWaiters.waitForVisabilityOfElementReturn(By.id("ez-accept-all"));
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
    }
}
