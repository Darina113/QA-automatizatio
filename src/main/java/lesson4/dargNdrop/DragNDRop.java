package lesson4.dargNdrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragNDRop {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ibuongiorno.com/about");
        Thread.sleep(3000);
        WebElement logoleft = driver.findElement(By.xpath("//img[@alt='Logo I Buongiorno']"));
        WebElement centr = driver.findElement(By.xpath("//h2[text()='I Buongiorno']"));
        WebElement contacts = driver.findElement(By.xpath("//a[text()='Contatti']"));
        System.out.println(logoleft.getLocation().x);
        System.out.println(contacts.getLocation().x);
        System.out.println(centr.getLocation().y);
        int y =centr.getLocation().y;
        Actions action = new Actions(driver);
        for(int i =0; i<4;i++){
            action.moveToElement(contacts,0,y).pause(5)
                    .clickAndHold().moveToElement(logoleft,0,y)
                    .release().build().perform();
            Thread.sleep(2000);
        }
        driver.quit();
    }
}
