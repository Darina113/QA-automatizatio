package lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebDriverMethods {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions(); //экземпдяр класса Хром
        options.addArguments("--disable-notifications"); //просим закрыть модальное окно

        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options); //экземпляр класса кот сразу закрывает модальное окно
        driver.manage().window().maximize();//выводим окно на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//ждем 10 сек
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); //загрузка страницы 10 сек
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10)); //отработка скрипта 10 сек

        //конф драйвера. Работа с Cookies.
        /*driver.get("https://itstep.dp.ua/ru");

        System.out.println(driver.manage().getCookies());
        Set<Cookie> set = driver.manage().getCookies();// сет из кукисов
        for (Cookie cookie:set){
            System.out.println(cookie);
        }
        System.out.println("Количество файлов cookie: "+set.toArray().length); //сделали массив из куки
        System.out.println("Отдельный файл cookie: "+ set.toArray()[4]);
        driver.quit();*/

        //getCurrentUrl()//
        /*driver.get("https://rozetka.com.ua/ua/");
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());//получение текущей ссылки
        Thread.sleep(2000);
        driver.get("https://itstep.dp.ua/");
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());
        driver.quit();
*/

//getTitle()
       /* driver.get("https://rozetka.com.ua/ua/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle()); //получение названия страницы
        Thread.sleep(2000);
        driver.get("https://itstep.dp.ua/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        driver.quit();*/

//getPageSource()
       /* driver.get("https://rozetka.com.ua/ua/");
        Thread.sleep(2000);
        System.out.println(driver.getPageSource()); //получение html, инфо
        Thread.sleep(2000);
        driver.quit();*/

        //navigate - навигация  по странице
      /*  driver.get("https://rozetka.com.ua/ua/");
        Thread.sleep(2000);
        Thread.sleep(2000);
        driver.navigate().to("https://itstep.dp.ua/"); // редерект - перейти на эту ссылку
        Thread.sleep(2000);
        driver.navigate().back(); //возвращение обратно на страницу розетки
        System.out.println(driver.getTitle());
        driver.navigate().refresh();//обновление страницы
        driver.navigate().forward();// шаг вперед
        System.out.println(driver.getCurrentUrl());
        driver.quit();*/

        //Работа с окнами 1 вариант
        /*driver.navigate().to("https://itstep.dp.ua/");
        System.out.println(driver.getWindowHandle());//идент.номер  окна https://itstep.dp.ua/
        ((JavascriptExecutor)driver).executeScript("window.open()");//открываем новое пустое окно
        System.out.println(driver.getWindowHandles());//идент.номер нового открытого окна
        driver.navigate().to("https://rozetka.com.ua/ua/"); //грузим новую урл в открытое окно
        Set<String> setWindowHandles = driver.getWindowHandles();
        String finalWindowHandle =
                (setWindowHandles.toArray()[setWindowHandles.toArray().length-1]).toString();
        driver.switchTo().window(finalWindowHandle);
        driver.get("https://uhomki.com.ua/ru/");*/

        //Работа с окнами 2 вариант
        /*driver.navigate().to("https://itstep.dp.ua/"); //открылось окно https://itstep.dp.ua/
        Set<String> setFirst = driver.getWindowHandles(); //получаем идент.номер первого окна из множества открытых окон
        ((JavascriptExecutor)driver).executeScript("window.open()");// открываем новое пустое окно
        Set<String> setSecond = driver.getWindowHandles();
        setSecond.removeAll(setFirst);//убираем дубликаты
        String finalDesc = setSecond.iterator().next(); //получаем дискриптор нужного нам окна
        driver.switchTo().window(finalDesc); //переключаемся на нужный дискриптор
        driver.get("https://uhomki.com.ua/ru/"); //грузим нужную ссылку в переключенный дискриптор*/


        //driver.findElement();
        //driver.findElements();



    }
}
