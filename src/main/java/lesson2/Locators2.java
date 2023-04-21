package lesson2;
//CSS SELECTORS

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//CSS SELECTORS
//поиск по тегу
        /*driver.get("https://www.guinnessworldrecords.com/search");
        driver.findElement(By.id("ez-accept-all")).click();//просто вставляем значение айди в ковычки
        Thread.sleep(2000);
        System.out.println(driver.findElements(By.xpath("//input")).size());//XPATH - сколько елементов input на странице (size())
        System.out.println(driver.findElements(By.cssSelector("input")).size());//cssSelector - сколько елементов input на странице (size())
        //чтобы корректно отображалась кол-во input ищем через консоль в DevTools
        driver.quit();*/

        //поиск по id #
        /*driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#search")).click();*/ //айди ищем вначале через - #

        //поиск по классу .class
        //.btn.btn-primary.blue
        /*driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        //driver.findElement(By.cssSelector(".btn.btn-primary.blue")).click(); //класс ищем вначале через точку, и все пробелы заменяем точками
        driver.findElement(By.cssSelector("button.btn.btn-primary.blue")).click();*/ //тут добавили имя тега button в начале и после через точку его название

        /*//атрибут пишем в []
        //a[title='Search']
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        //driver.findElement(By.cssSelector(".btn.btn-primary.blue")).click();
        driver.findElement(By.cssSelector("[title='Search']")).click();//ищем любой другой атрибут черех []

        //поиск по буквосочетанию атрибута
        Thread.sleep(2000);
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.cssSelector("[title*='arc']")).click();//чтобы искать по буквосочетанию в названии атрибута вконце ставим *

        //поиск по первым символам
        Thread.sleep(2000);
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.cssSelector("[title^='Sear']")).click(); //чтобы искать по первым символам в названии атрибута вконце ставим ^

        //поиск по последним
        Thread.sleep(2000);
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.cssSelector("[title$='rch']")).click();*/ //чтобы искать по первым символам в названии атрибута вконце ставим $

        /*//нахождение вложенного элемента
        //двигаться по дереву через CSS SELECTOR можем только вниз. В DevTools опускаемся через пробел. Чтобы перескочить папку пишем >(папка)>
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        driver.findElements(By.cssSelector
                (".secondary_menu_wrapper.block.block-12-12.no-margin .columned.block.block-4-12>a")).get(1).click();//.get(1)- выбираем 1 элемент из всех элементов, а поиск ставим driver.findElements
        //.secondary_menu_wrapper.block.block-12-12.no-margin .columned.block.block-4-12>a*/

        //Ключевое слово not
        //.btn:not(.btn-primary)
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btn:not(.btn-primary)")).click();



    }
}
