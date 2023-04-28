package lesson4.ActionFinalMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DifferentClicks {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        Thread.sleep(4000);
        //далее возникает frame с кукисами
        //переходим на frame так как кукисы идут во вложенной странице
        driver.switchTo().frame("gdpr-consent-notice");//перекл. на frame с кукисами по его айди
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Принять всё']")).click();//принимаем кнопку кукисов
        Actions actions = new Actions(driver);//создаем экз.класса actions
        actions.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();//contextClick - клик правой кнопкой мыши, нажимаем на кнопку
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Delete']")).click();//находим во всплывающим окне кнопку Delete и нажимаем на нее
        Thread.sleep(1000);
        //далее возникает модальное окно "Подтеврдите действие" и поэтому создаем экз.его класса
        Alert alert = driver.switchTo().alert();//переходим на алерт
        Thread.sleep(1000);
        //далее проверяем совпадает ли текст модального окна который мы ожидаем с фактическим
        System.out.println("Совпадает ли текст 1 модального окна? "+alert.getText().equals("clicked: delete"));
        alert.accept();// принимаем наш алерт
        Thread.sleep(1000);
        //пробуем дальше дабл клик
        actions.doubleClick(driver.findElement
                (By.xpath("//button[text()='Double-Click Me To See Alert']"))).click().perform();//ищем кнопку Дабл клик и нажимаем на нее двойным кликом
        Thread.sleep(1000);
        //далее возникает еще модальное окно "Подветрдите действие"
        driver.switchTo().alert();//перекл. на алерт
        //далее проверяем совпадает ли текст модального окна который мы ожидаем с фактическим
        System.out.println("Совпадает ли текст 2 модального окна? "
                +alert.getText().equals("You double clicked me.. Thank You.."));
        alert.dismiss();// отменяем алерт
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
