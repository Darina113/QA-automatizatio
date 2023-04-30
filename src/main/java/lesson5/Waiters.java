package lesson5;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //ожидания это -конфигуратор работы нашего драйвера.

        //НЕЯВНЫЕ ОЖИДАНИЯ
        //неявные ожидания
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// Duration.ofSeconds-кол-во сек которые драйвер будет ждать прежде чем выкинет исключение
        //пример- ожидать появление элемента

        //неявные ожидания загрузки страницы
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));//
        //неявные ожидания отработки скриптов страницы
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));//

        //ЯВНЫЕ ОЖИДАНИЯ
        //чтобы начать работать с явными ожиданиями нужно создать экземпляр класса WebDriverWait
        /*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//в его конструктор требует положить экземпляр драйвера (driver), и его ожидания (Duration.ofSeconds)
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));//until - ожидаем функцию,10 сек пока не выполнится условие - ExpectedConditions.presenceOfElementLocated (ожидание появл.эл-та по какому-то локатору)
        //и пока этот элемент не появится - след.этап начинаться не будет. Явные ожидания отрабатывают 1 раз

        //1 вар использования С созданием экземпляра
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));//ждем появление элемента и когда он появляется - заносим его сразу в нашу переменную
        //2 вар использования БЕЗ создания экземпляра
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
        //3 вар Без создания экземпляра ожидания
        WebElement element =  new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
        */


        //visibilityOfElementLocated(), frameToBeAvailableAndSwitchToIt(), alertIsPresent()
        /*
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//создаем экземпл наших ожиданий
        WebElement acceptCoockies = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("accept-choices")));//ожидаем появление элемента (By.id("accept-choices"))
        acceptCoockies.click();//подтверждаем принятие кукисов

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='iframeResult']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='iframeResult']")));//ждем появления frame и переключаемся на него
        driver.findElement(By.xpath("//button[text()='Try it']")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());//как только алерт появится мы сразу переходим на него
        System.out.println(alert.getText());
        alert.accept();//принимаем алерт
        System.out.println(driver.getTitle());
        driver.quit();
         */


        //elementToBeClickable(), elementToBeSelected(), elementSelectionStateToBe()
        /*
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ez-accept-all")));
        accept.click();
        WebElement pass = driver.findElement(By.xpath("//input[ @id='Password']"));
        WebElement userName = driver.findElement(By.xpath("//input[ @id='Username']"));
        WebElement checkBox = driver.findElement(By.xpath("//input[ @id='RememberMe']"));

        wait.until(ExpectedConditions.elementToBeClickable(checkBox));//ждем пока наш элемент checkBox будет кликабельным
        System.out.println(driver.getTitle());
        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("h1")));
        wait.until(ExpectedConditions.elementToBeSelected(checkBox));//ждем пока checkBox будет выбранным
        pass.sendKeys("111111111");
        //wait.until(ExpectedConditions.elementToBeSelected(userName));//elementToBeSelected - не работает к не селектным полям
        wait.until(ExpectedConditions.elementSelectionStateToBe(checkBox,false));//elementSelectionStateToBe- выбран элемент или нет,мы ставим нет - false
        userName.sendKeys("Just Text");
         */



        //presenceOfElementLocated(), textToBePresentInElementValue(), invisibilityOf(),
        //titleContains(), titleIs()
        /*
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ez-accept-all")));
        accept.click();
        WebElement pass = driver.findElement(By.xpath("//input[ @id='Password']"));
        WebElement userName = driver.findElement(By.xpath("//input[ @id='Username']"));
        WebElement checkBox = driver.findElement(By.xpath("//input[ @id='RememberMe']"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Please fill in the Email field.']")));//ждем пока элемент станет видимым
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Please fill in the Email field.']")));//  отработал
        wait.until(ExpectedConditions.textToBePresentInElementValue(userName,"text"));//ждем когда текст появится в указаном поле (userName)
        pass.sendKeys("1121212");
        userName.clear();//очищаем
        userName.submit();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Please fill in the Email field.']")));//ожидаем исчезновения текста
        driver.navigate().to("https://itstep.dp.ua/");//в активном окне переходим на ссылку

        wait.until(ExpectedConditions.titleIs("IT курси у Дніпрі з працевлаштуванням | Академія IT STEP"));//ждем чтообы название страницы стало необходимым
        wait.until(ExpectedConditions.titleContains("Академія IT STEP"));//ждем чтобы название вкл в себя текст
        driver.findElement(By.xpath("//div[@class='header__wrap']//a[text()=' Блог ']")).click();
         */

        //СВОБОДНЫЕ ОЖИДАНИЯ
        //чтобы работать со свободными ожиданиями нужно создать экземпляр класса FluentWait<WebDriver>
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))//какой промежуток времени нам нужно для ожидания условия
                .pollingEvery(Duration.ofSeconds(2))//наступление результата с какой частотой
                .ignoring(NoSuchElementException.class)//какие типы исключений будем игнорировать
                .ignoring(ElementNotInteractableException.class)//какие типы исключений будем игнорировать
                .ignoring(InvalidElementStateException.class)//какие типы исключений будем игнорировать
                .ignoring(StaleElementReferenceException.class);//какие типы исключений будем игнорировать

        driver.get("https://itstep.dp.ua/");
        fluentWait.until(ExpectedConditions.titleContains("Академія IT STEP"));//ожидаем появление текста
        driver.findElement(By.xpath("//div[@class='header__wrap']//a[text()=' Блог ']")).click();//после кликается на элемент

    }
}
