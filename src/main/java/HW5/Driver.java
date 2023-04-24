package HW5;
//запуск 1,2,3,4 задач. 5я отдельным доком идет
import HW5.Task2.Task2;
import HW5.Task3.*;
import HW5.Task4.Task4;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.Keys.*;

public class Driver {
    private static class Url {
        private static final String uhomki = "https://uhomki.com.ua/";
        private static final String zoo = "https://zoo.kiev.ua/";
        private static final String w3school = "https://www.w3schools.com/";
        private static final String taxi = "https://taxi838.ua/ru/dnepr/";
        private static final String klopotenko = "https://klopotenko.com/";

    }

    public static void main(String[] args) throws InterruptedException, ZeroValID, ZeroValTagName, ZeroValClass, ZeroValName, ZeroValGetText {
        System.setProperty("webdriver.chrome.driver", "/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //вызов большого окна
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10)); //отработка скрипта 10 сек

        // 1)
        //Написать прогу, кот. будет открывать 5 различных стр в новых окнах
        //Прописать цикл, который будет переключаться поочередно через все страницы,
        //для каждой страницы выводить в консоль название и ссылку на эту страницу.
        //И будет закрывать ту страницу в названии которой есть слово зоопарк.

        driver.get(Url.uhomki); //открываем окно у хомки
        Thread.sleep(2000);//замедляем действие
        Set<String> setFirst = driver.getWindowHandles(); //получаем идент.номер первого окна из множества открытых окон

        ((JavascriptExecutor) driver).executeScript("window.open()"); //открываем новое пустое окно
        Set<String> setSecond = driver.getWindowHandles(); //получаем идент.номер второго окна из множества открытых окон
        setSecond.removeAll(setFirst);//убираем дубликаты
        String secondDesc = setSecond.iterator().next(); //получаем дискриптор нужного нам окна
        driver.switchTo().window(secondDesc); //переключаемся на нужный дискриптор
        driver.get(Url.zoo); //грузим в полученный дискриптор нужную ссылку
        Thread.sleep(2000);//замедляем действие

        ((JavascriptExecutor) driver).executeScript("window.open()"); //открываем новое пустое окно
        Set<String> setThird = driver.getWindowHandles(); //получаем идент.номер третьего окна из множества открытых окон
        setThird.removeAll(setFirst);//убираем дубликаты
        setThird.removeAll(setSecond);//убираем дубликаты
        String thirdDesc = setThird.iterator().next(); //получаем дискриптор нужного нам окна
        driver.switchTo().window(thirdDesc); //переключаемся на нужный дискриптор
        driver.get(Url.w3school);//грузим в полученный дискриптор нужную ссылку
        Thread.sleep(2000);//замедляем действие

        ((JavascriptExecutor) driver).executeScript("window.open()"); //открываем новое пустое окно
        Set<String> setFourth = driver.getWindowHandles(); //получаем идент.номер четвертого окна из множества открытых окон
        setFourth.removeAll(setFirst);//убираем дубликаты
        setFourth.removeAll(setSecond);//убираем дубликаты
        setFourth.removeAll(setThird);//убираем дубликаты
        String fourthDesc = setFourth.iterator().next(); //получаем дискриптор нужного нам окна
        driver.switchTo().window(fourthDesc); //переключаемся на нужный дискриптор
        driver.get(Url.taxi);//грузим в полученный дискриптор нужную ссылку
        Thread.sleep(2000);//замедляем действие

        ((JavascriptExecutor) driver).executeScript("window.open()"); //открываем новое пустое окно
        Set<String> setFifth = driver.getWindowHandles(); //получаем идент.номер пятого окна из множества открытых окон
        setFifth.removeAll(setFirst);//убираем дубликаты
        setFifth.removeAll(setSecond);//убираем дубликаты
        setFifth.removeAll(setThird);//убираем дубликаты
        setFifth.removeAll(setFourth);//убираем дубликаты
        String fifthDesc = setFifth.iterator().next(); //получаем дискриптор нужного нам окна
        driver.switchTo().window(fifthDesc); //переключаемся на нужный дискриптор
        driver.get(Url.klopotenko);//грузим в полученный дискриптор нужную ссылку
        Thread.sleep(2000);//замедляем действие

        Set<String> count = driver.getWindowHandles(); //сделали массив из дискрипторов
        Iterator<String> i = count.iterator(); //разделили их

        for (int k = 0; k < count.size(); k++) {
            i.hasNext();
            String childWindow = i.next();
            driver.switchTo().window(childWindow);
            System.out.println(driver.getCurrentUrl()); //получение текущей ссылки
            System.out.println(driver.getTitle()); //получение названия страницы
            {
                if (driver.getTitle().toLowerCase().contains("зоопарк")) {
                    driver.close();
                }
            }


            // 2)
        /*driver.get(Url.uhomki);
        Thread.sleep(2000);
        Task2 abc = new Task2();
        WebElement search = driver.findElement(By.cssSelector(".search__input"));
        WebElement switchLang = driver.findElement(By.cssSelector(".lang-menu"));
        abc.vivodLoc(search,switchLang);
        driver.quit(); */


            // 3)
            driver.get(Url.uhomki);
            Thread.sleep(2000);
            Task3 ob = new Task3();
            WebElement element1 = driver.findElement(By.xpath("//div[@class='upButton']"));
            try {
                ob.iskluchenie(element1);
            } catch (ZeroValID | ZeroValTagName | ZeroValClass | ZeroValName | ZeroValGetText exception) {
                System.out.println(exception.getMessage());
            }
            driver.quit();

            // 4)
        /*driver.get(Url.uhomki);
        Thread.sleep(200);
        Task4 ob =new Task4();
        WebElement container = driver.findElement(By.xpath("//ul[contains(@class,'products-menu__container')]"));
        List<WebElement> footer = driver.findElements(By.xpath("//ul[@class='footer__menu']"));
        ob.vivodInfo(container,footer);
        driver.quit(); */

        }
    }
}

