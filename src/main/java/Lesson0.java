import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson0 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        WebDriver driver=new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/default.asp");
    }
}
