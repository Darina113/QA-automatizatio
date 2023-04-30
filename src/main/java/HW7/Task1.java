package HW7;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.Keys.CANCEL;
import static org.openqa.selenium.Keys.ENTER;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //вызов большого окна
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(5)); //отработка скрипта 5 мин
        //1
        driver.get("https://www.google.com/search");
        Thread.sleep(2000);
        //2
        WebElement search= driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        search.sendKeys("https://www.guinnessworldrecords.com/account/register?");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        Set<String> setFirst = driver.getWindowHandles(); //получаем идент.номер первого окна из множества открытых окон
        Actions actions = new Actions(driver);
        //a[@href='https://www.guinnessworldrecords.com/account/register']
        WebElement res1=driver.findElement(By.xpath("//div[@class='byrV5b']"));
        actions.moveToElement(res1).keyDown(Keys.COMMAND).click().keyUp(Keys.COMMAND).build().perform();
        Set<String> setSecond = driver.getWindowHandles(); //получаем идент.номер второго окна из множества открытых окон
        setSecond.removeAll(setFirst);//убираем дубликаты
        String secondDesc = setSecond.iterator().next(); //получаем дискриптор нужного нам окна
        Thread.sleep(2000);

        //3
        actions.moveToElement(driver.findElement(By.xpath("//span[@class='ExCKkf z1asCe rzyADb']"))).click().perform();
        WebElement search2= driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        search2.sendKeys("https://www.hyrtutorials.com/p/alertsdemo.html");
        search2.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement res2= driver.findElement(By.xpath("//div[@class='byrV5b']"));
        actions.moveToElement(res2).keyDown(Keys.COMMAND).click().keyUp(Keys.COMMAND).build().perform();//Command - потому что я с Мака
        Set<String> setThird = driver.getWindowHandles(); //получаем идент.номер третьего окна из множества открытых окон
        setThird.removeAll(setFirst);//убираем дубликаты
        setThird.removeAll(setSecond);//убираем дубликаты
        String thirdDesc = setThird.iterator().next(); //получаем дискриптор нужного нам окна

        //4
        driver.navigate().to("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");// в текущем окне переключаемся на новую ссылку
        Thread.sleep(2000);
        WebElement frame= driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame(frame);//переключаемся на frame (вложеная страница)
        Thread.sleep(2000);
        WebElement firstName= driver.findElement(By.xpath("//input[@id='fname']"));
        firstName.clear();
        firstName.sendKeys("Darina");
        Thread.sleep(2000);
        WebElement lastName= driver.findElement(By.xpath("//input[@id='lname']"));
        lastName.clear();
        lastName.sendKeys("Gladkova");
        Thread.sleep(2000);
        WebElement submitUser= driver.findElement(By.xpath("//input[@type='submit']"));
        submitUser.click();
        Thread.sleep(2000);
        WebElement messege= driver.findElement(By.xpath("//div[@class='w3-panel w3-pale-yellow w3-leftbar w3-border-yellow']"));
        System.out.println("Сообщение со страницы w3school: "+messege.getText());

        //5
        driver.switchTo().window(secondDesc); //переключаемся на нужный дискриптор
        Thread.sleep(2000);
        WebElement userLastName=driver.findElement(By.id("LastName"));
        userLastName.sendKeys("Gladkova");
        Thread.sleep(2000);
        WebElement userFirstName=driver.findElement(By.id("FirstName"));
        userFirstName.sendKeys("Darina");
        Thread.sleep(2000);
        driver.findElement(By.id("DateOfBirthDay")).sendKeys("13");
        Thread.sleep(2000);
        driver.findElement(By.id("DateOfBirthMonth")).sendKeys("04");
        Thread.sleep(2000);
        driver.findElement(By.id("DateOfBirthYear")).sendKeys("1996");
        Thread.sleep(2000);
        WebElement countryElement = driver.findElement(By.id("Country"));//in DevTools ищем класс select и его атрибут, в данном случае айди
        Select countrySelect = new Select(countryElement);//создаем объект класса Select и в его метод вставляем элемент
        countrySelect.selectByVisibleText("Ukraine");
        Thread.sleep(3000);
        driver.findElement(By.id("State")).sendKeys("Kharkiv");
        Thread.sleep(2000);
        driver.findElement(By.id("EmailAddress")).sendKeys("Darina.Gladkova@gmail.com");
        driver.findElement(By.id("ConfirmEmailAddress")).sendKeys("Darina.Gladkova@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Darina13");
        Thread.sleep(2000);
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Marina15",ENTER);
        Thread.sleep(2000);
        WebElement results= driver.findElement(By.xpath("//span[@for='ConfirmPassword']"));
        System.out.println("Сообщение со страницы guiness: "+results.getText());

        //6
        driver.switchTo().window(thirdDesc);//переключаемся на нужный дискриптор
        Thread.sleep(2000);
        WebElement but1= driver.findElement(By.xpath("//button[@id='alertBox']"));
        but1.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();//чтобы запустить работу с Алертом нужно создать экзм.класса Alert, а дальше перекл. на него
        alert.accept();//принимаем алерт
        System.out.println("Сообщение для 1го алерта на странице hyrtu: "+driver.findElement(By.xpath("//div[@id='output']")).getText());//выводим текст Алерта (1го модального окна)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        WebElement but2= driver.findElement(By.xpath("//button[@id='confirmBox']"));
        but2.click();
        Thread.sleep(2000);
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();//отменяем алерт
        System.out.println("Сообщение для 2го алерта на странице hyrtu: "+driver.findElement(By.xpath("//div[@id='output']")).getText());
        WebElement but3= driver.findElement(By.xpath("//button[@id='promptBox']"));
        but3.click();
        Thread.sleep(2000);
        Alert alert3 = driver.switchTo().alert();
        Thread.sleep(2000);
        alert3.sendKeys("Final step of this task");
        Thread.sleep(2000);
        alert3.accept();
        System.out.println("Сообщение для 3го алерта на странице hyrtu: "+driver.findElement(By.xpath("//div[@id='output']")).getText());



    }
}
