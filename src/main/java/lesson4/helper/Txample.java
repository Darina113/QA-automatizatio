package lesson4.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Txample {
    public static void getAttribute(WebElement element) throws NoSuchAlertEx, NoSuchNameEx, NoSuchIdEx {
        System.out.println("Название тега: "+element.getTagName());
        if(element.getAttribute("i2d")==null){
            throw new NoSuchIdEx("Аттрибута айди нет");
        }else {
            System.out.println("Аттрибута айди равен "+element.getAttribute("id"));
        }

        if(element.getAttribute("name")==null){
            throw new NoSuchNameEx("Аттрибута нэйм нет");
        }else {
            System.out.println("Аттрибута name равен "+element.getAttribute("name"));
        }

        if(element.getAttribute("alert")==null){
            throw new NoSuchAlertEx("Аттрибута алерт нет");
        }else {
            System.out.println("Аттрибута alert равен "+element.getAttribute("alert"));
        }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.getMessage();
        }
        try {
            getAttribute(driver.findElement(By.xpath("//input[@name='q']")));
        }catch(NoSuchIdEx|NoSuchNameEx|NoSuchAlertEx ex){
            System.out.println(ex.getMessage());
        }
        driver.quit();
    }
}
