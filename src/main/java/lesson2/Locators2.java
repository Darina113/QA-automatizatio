package lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//поиск по тегу
        /*driver.get("https://www.guinnessworldrecords.com/search");
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElements(By.xpath("//input")).size());
        System.out.println(driver.findElements(By.cssSelector("input")).size());
        driver.quit();*/

        //поиск по id #
        /*driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#search")).click();*/

        //поиск по классу .class
        //.btn.btn-primary.blue
        /*driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        //driver.findElement(By.cssSelector(".btn.btn-primary.blue")).click();
        driver.findElement(By.cssSelector("button.btn.btn-primary.blue")).click();*/

        /*//атрибут пишем в []
        //a[title='Search']
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        //driver.findElement(By.cssSelector(".btn.btn-primary.blue")).click();
        driver.findElement(By.cssSelector("[title='Search']")).click();
        //поиск по буквосочетанию атрибута
        Thread.sleep(2000);
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.cssSelector("[title*='arc']")).click();
        //поиск по первым символам
        Thread.sleep(2000);
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.cssSelector("[title^='Sear']")).click();
        //поиск по последним
        Thread.sleep(2000);
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.cssSelector("[title$='rch']")).click();*/

        /*//нахождение вложенного элемента
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        driver.findElements(By.cssSelector
                (".secondary_menu_wrapper.block.block-12-12.no-margin .columned.block.block-4-12>a")).get(1).click();
        //.secondary_menu_wrapper.block.block-12-12.no-margin .columned.block.block-4-12>a*/

        //Ключевое слово not
        //.btn:not(.btn-primary)
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btn:not(.btn-primary)")).click();



    }
}
