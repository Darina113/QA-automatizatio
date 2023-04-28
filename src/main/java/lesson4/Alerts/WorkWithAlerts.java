package lesson4.Alerts;
//работа с диалоговыми окнами(модальными окнами)
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkWithAlerts {
    public static void main(String[] args) throws InterruptedException {
        //You successfully clicked an alert
        //You clicked: Cancel
        //You entered: asdaasd
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //button[text()='Click for JS Alert']



        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();//чтобы запустить работу с Алертом нужно создать экзм.класса Alert, а дальше перекл. на него
        System.out.println(alert.getText());//выводим текст Алерта
        alert.accept();//принимаем алерт
        Thread.sleep(1000);
        System.out.println("Cоответствует ли 1 текст ожидаемому: "+
                driver.findElement(By.xpath("//p[@id='result']")).getText()
                        .equals("You successfully clicked an alert"));//выведет либо true or false

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(1000);
        Alert alert2 = driver.switchTo().alert();//перекл. на 2й алерт
        System.out.println(alert2.getText());//выводим текст Алерта
        alert2.dismiss();//отмена алерт2
        Thread.sleep(1000);
        System.out.println("Cоответствует 2 ли текст ожидаемому: "+
                driver.findElement(By.xpath("//p[@id='result']")).getText()
                        .equals("You clicked: Cancel"));

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        String text = "введенный текст";//создаем строку
        Alert alert3 = driver.switchTo().alert();//перекл. на 3й алерт
        System.out.println(alert3.getText());//выводим текст Алерта
        alert3.sendKeys(text); //вводим созданную строку
        alert.accept();//принимаем алерт3
        Thread.sleep(1000);
        System.out.println("Cоответствует ли текст 3 ожидаемому: "+
                driver.findElement(By.xpath("//p[@id='result']")).getText()
                        .equals("You entered: "+text));
        System.out.println("Cодержится ли тескт: "+
                driver.findElement(By.xpath("//p[@id='result']")).getText().contains(text));
        driver.quit();//содержится ли то что мы ввели в результатах алерта


    }
}
