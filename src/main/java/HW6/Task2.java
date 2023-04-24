package HW6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

//2) http://www.ashortjourney.com/
//Написать программу, которая будет автоматизировать сценарий показанный на видео "Сценарий для автоматизии.mp4".
public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //вызов большого окна
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20)); //отработка скрипта 20 сек
        Actions actions = new Actions(driver);//объект драйвера помещаем в него. Для работы с классом Actions и его методами необходимо создать экземпляр
        driver.get("http://www.ashortjourney.com/");
        Thread.sleep(7000);
        //[stroke-width='4']
        WebElement bigCircle=driver.findElement(By.cssSelector("[stroke-width='4']"));
        WebElement smallCircle= driver.findElement(By.cssSelector("[r='8']"));
        //actions.dragAndDrop(bigCircle,smallCircle).perform();// 1 var
        int x=bigCircle.getLocation().x+(bigCircle.getSize().width/2);
        int y=bigCircle.getLocation().y+(bigCircle.getSize().height/2);
        int x2=smallCircle.getLocation().x+(smallCircle.getSize().width/2);
        int y2=smallCircle.getLocation().y+(smallCircle.getSize().height/2);
        actions.moveByOffset(x,y).clickAndHold().moveByOffset(x2,y2).release().build().perform();//2 var
        Thread.sleep(5000);

        WebElement bigCircle2=driver.findElement(By.cssSelector("[stroke-width='4']"));
        WebElement smallCircle2=driver.findElement(By.cssSelector("[r='8']"));
        actions.dragAndDrop(bigCircle2,smallCircle2).perform();
        Thread.sleep(5000);

        WebElement bigCircle3= driver.findElement(By.cssSelector("[stroke-width='4']"));
        WebElement smallCircle3= driver.findElement(By.cssSelector("[r='8']"));
        actions.dragAndDrop(bigCircle3,smallCircle3).perform();
        Thread.sleep(5000);

        WebElement bigCircle4= driver.findElement(By.cssSelector("[stroke-width='4']"));
        WebElement smallCircle4= driver.findElement(By.cssSelector("[r='8']"));
        actions.dragAndDrop(bigCircle4,smallCircle4).perform();
        Thread.sleep(5000);

        WebElement bigCircle5= driver.findElement(By.xpath("//*[local-name() = 'circle'][2]"));
        WebElement smallCircle5= driver.findElement(By.xpath("//li[@id='ui-credits']"));
        //actions.dragAndDrop(bigCircle5,smallCircle5).pause(10000).build().perform();
        actions.moveToElement(bigCircle5).clickAndHold().moveToElement(smallCircle5).release().build().perform();
        Thread.sleep(5000);

        WebElement bigCircle6= driver.findElement(By.cssSelector("[stroke-width='4']"));
        WebElement smallCircle6=driver.findElement(By.cssSelector("[r='8']"));
        actions.dragAndDrop(bigCircle6,smallCircle6).perform();
        Thread.sleep(5000);

        WebElement bigCircle7= driver.findElement(By.cssSelector("[stroke-width='4']"));
        WebElement smallCircle7=driver.findElement(By.cssSelector("[r='8']"));
        actions.dragAndDrop(bigCircle7,smallCircle7).perform();
        Thread.sleep(5000);

        WebElement postcard= driver.findElement(By.xpath("//div[@id='postcard-back-content']/textarea"));
        postcard.sendKeys("Задание выполнено!");
        Thread.sleep(5000);

        driver.quit();




    }
}
