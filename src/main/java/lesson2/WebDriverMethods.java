package lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebDriverMethods {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

        //конф драйвера. Работа с Cookies.
        /*driver.get("https://itstep.dp.ua/ru");

        System.out.println(driver.manage().getCookies());
        Set<Cookie> set = driver.manage().getCookies();
        for (Cookie cookie:set){
            System.out.println(cookie);
        }
        System.out.println("Количество файлов cookie: "+set.toArray().length);
        System.out.println("Отдельный файл cookie: "+ set.toArray()[4]);
        driver.quit();*/

        //getCurrentUrl()
        /*driver.get("https://rozetka.com.ua/ua/");
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.get("https://itstep.dp.ua/");
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());
        driver.quit();
*/

//getTitle()
       /* driver.get("https://rozetka.com.ua/ua/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.get("https://itstep.dp.ua/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        driver.quit();*/

//getPageSource()
       /* driver.get("https://rozetka.com.ua/ua/");
        Thread.sleep(2000);
        System.out.println(driver.getPageSource());
        Thread.sleep(2000);
        driver.quit();*/

        //navigate
      /*  driver.get("https://rozetka.com.ua/ua/");
        Thread.sleep(2000);
        Thread.sleep(2000);
        driver.navigate().to("https://itstep.dp.ua/");
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println(driver.getTitle());
        driver.navigate().refresh();
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());
        driver.quit();*/

        //Работа с окнами 1 вариант
        /*driver.navigate().to("https://itstep.dp.ua/");
        System.out.println(driver.getWindowHandle());
        ((JavascriptExecutor)driver).executeScript("window.open()");
        System.out.println(driver.getWindowHandles());
        driver.navigate().to("https://rozetka.com.ua/ua/");
        Set<String> setWindowHandles = driver.getWindowHandles();
        String finalWindowHandle =
                (setWindowHandles.toArray()[setWindowHandles.toArray().length-1]).toString();
        driver.switchTo().window(finalWindowHandle);
        driver.get("https://uhomki.com.ua/ru/");*/

        //Работа с окнами 2 вариант
        /*driver.navigate().to("https://itstep.dp.ua/");
        Set<String> setFirst = driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> setSecond = driver.getWindowHandles();
        setSecond.removeAll(setFirst);
        String finalDesc = setSecond.iterator().next();
        driver.switchTo().window(finalDesc);
        driver.get("https://uhomki.com.ua/ru/");*/


        //driver.findElement();
        //driver.findElements();



    }
}
