package lesson9.variation2;

import lesson5.MyWaiters;
import lesson9.ActionClass;
import lesson9.Assertions;
import lesson9.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DragNDropTest2 {
    private static class Xpath{
        private  static final String fisrt5000 = "//li[@id='fourth'][1]/a";
        private  static final String fisrt5000Field = "//ol[@id='amt7']";
        private  static final String second5000 = "//li[@id='fourth'][2]/a";
        private  static final String second5000Field = "//ol[@id='amt8']";
        private  static final String bank = "//li[@id='credit2']/a";
        private  static final String bankField = "//ol[@id='bank']";
        private  static final String sale = "//li[@id='credit1']/a";
        private  static final String saleField = "//ol[@id='loan']";
    }
    @Test
    public void dragNDrop() {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        MyWaiters myWaiters = new MyWaiters(driver);
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        Elements elements = new Elements(driver);
        ActionClass actions = new ActionClass(driver);
        Assertions assertions = new Assertions(driver);

        myWaiters.waitPresenceOfElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        myWaiters.waitForFrameAndSwitchToIt(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        myWaiters.waitPresenceOfElementReturn(By.xpath("//span[text()='Принять всё']")).click();

        actions.dragNdrop(Xpath.fisrt5000, Xpath.fisrt5000Field);
        actions.dragNdrop(Xpath.second5000,Xpath.second5000Field);
        actions.dragNdrop(Xpath.bank,Xpath.bankField );
        actions.dragNdrop(Xpath.sale,Xpath.saleField );

        assertions.elementIsDisplayed("//a[text()='Perfect!']");
        assertions.equalsOfElementAndLabelText("//a[text()='Perfect!']", "Perfect!");
        driver.quit();
    }
}
