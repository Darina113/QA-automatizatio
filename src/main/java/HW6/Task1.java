package HW6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


//1) http://only-testing-blog.blogspot.com/2014/01/textbox.html?
//Написать программу реализующую действие показанное на "видео1.mp4".
//После выполнения программы на консоли должна выводится информация в следующем виде:
//Автомобили доступные для выбора:
//Volvo, BMW, Opel, Audi, Toyota, Renault, Maruti Car.
//Страны из первой таблицы:
//USA, Russia, Japan, Mexico, India, Malaysia, Greece.
//Страны из второй таблицы:
//France, Germany, Italy, Spain.
public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //вызов большого окна
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(5)); //отработка скрипта 5 мин
        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");
        Actions actions = new Actions(driver);//объект драйвера помещаем в него. Для работы с классом Actions и его методами необходимо создать экземпляр
        WebElement carElement=driver.findElement(By.id("Carlist")); //in DevTools ищем класс select и его атрибут, в данном случае айди
        //actions.click(carElement).build().perform();
        //actions.moveToElement(driver.findElement(By.id("car2"))).build().perform();
        //actions.moveToElement(driver.findElement(By.id("car3"))).build().perform();
        //actions.moveToElement(driver.findElement(By.id("car4"))).build().perform();
        //actions.moveToElement(driver.findElement(By.id("car5"))).build().perform();
        //actions.moveToElement(driver.findElement(By.id("car5"))).click().build().perform();
        Select carSelect=new Select(carElement);//создаем первый объект класса Select и в его метод вставляем элемент
        carSelect.selectByVisibleText("Renault");//у объекта класса Select вызываем метод selectByVisibleText() и вставляем значение кот.необходимо выбрать
        WebElement fromElement= driver.findElement(By.xpath("//select[@name='FromLB']"));//in DevTools ищем класс select и его атрибут, в данном случае xPath
        Select fromSelect=new Select(fromElement);//создаем второй объект класса Select и в его метод вставляем второй элемент
        fromSelect.selectByIndex(2);
        Thread.sleep(2000);
        fromSelect.selectByIndex(5);//India
        Thread.sleep(2000);
        fromSelect.deselectByIndex(5);//India
        Thread.sleep(2000);
        fromSelect.selectByIndex(6);//Germany
        Thread.sleep(2000);
        fromSelect.selectByIndex(7);//Italy
        Thread.sleep(2000);
        fromSelect.selectByIndex(9);//Malaysia
        Thread.sleep(2000);
        fromSelect.deselectByIndex(9);//Malaysia
        Thread.sleep(2000);
        fromSelect.selectByIndex(8);//Spain
        Thread.sleep(2000);
        WebElement add = driver.findElement(By.xpath("//input[@onclick='move(this.form.FromLB,this.form.ToLB)']"));
        add.click();

        //вывод авто
        List<WebElement> cars=carSelect.getOptions();
        System.out.print("Автомобили доступные для выбора: ");
        for (WebElement car :
                cars) {
            System.out.print(car.getText()+" ");
        }

        //вывод 1й табл
        List<WebElement> countries= fromSelect.getOptions();
        System.out.print("\nСтраны из первой таблицы: ");
        for (WebElement country :
                countries) {
            System.out.print(country.getText()+" ");
        }

        //вывод 2й табл
        WebElement stran2tabl= driver.findElement(By.xpath("//select[@name='ToLB']"));
        Select stranSelect=new Select(stran2tabl);
        List<WebElement> stran2=stranSelect.getOptions();
        System.out.print("\nСтраны из второй таблицы: ");
        for (WebElement stran:stran2
             ) {
            System.out.print(stran.getText()+" ");
        }
        driver.quit();

    }
}
