package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragNdropEx {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        driver.get("https://www.signesduquotidien.org/");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//i[@id='menu-btn']")).click();//открыли меню из которого вылетели кружочки
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement
                (By.xpath("//i[@class='menu-icon icon-ouverture']"))).
                clickAndHold().moveToElement(driver.findElement(By.xpath("//i[@class='menu-icon dots-icon']")))
                .release().build().perform();//moveToElement -перемещаем курсор, clickAndHold- нажимает и не отпускает,.release()- отпускает курсор,.build()-  генерит все что было до билда
        Thread.sleep(6000);
        System.out.println(driver.getTitle());//выводим текст страницы
        System.out.println("============");
        driver.findElement(By.xpath("//a[@id='close-btn']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[@id='menu-btn']")).click();
        Thread.sleep(2000);
        String string ="Это наша строка";
        Integer integer = 1;
        WebElement baseElement = driver.findElement(By.xpath("//i[@class='menu-icon icon-projets']"));
        WebElement targetElement = driver.findElement(By.xpath("//i[@class='menu-icon dots-icon']"));
        actions.dragAndDrop(baseElement,targetElement).perform();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.quit();
        //i[@class='menu-icon dots-icon']
        //i[@class='menu-icon icon-ouverture']
        //i[@class='menu-icon icon-projets']
        //i[@class='menu-icon dots-icon']
        //a[@id='close-btn']

    }
}
