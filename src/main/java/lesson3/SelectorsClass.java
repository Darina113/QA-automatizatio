package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectorsClass {
    private static class Locators {
        private static final By city = By.xpath("//select[@id='city_list']");
        private static final By city2 = By.id("city_list");
    }
    public static void main(String[] args) throws InterruptedException {
        //Для работы с дропдаунами необходимо создать объект класса Select
        //для получения возможности работать с его методами
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ktokuda.net/");
        WebElement countryElement = driver.findElement(By.id("itt_country"));//in DevTools ищем класс select и его атрибут, в данном случае айди
        Select countrySelect = new Select(countryElement);//создаем объект класса Select и в его метод вставляем элемент


        //selectByVisibleText(); выбор элемента с определенным текстом.он обычно в классах option
        countrySelect.selectByVisibleText("Греция");//у объекта класса Select вызываем метод selectByVisibleText()
        //Thread.sleep(4000);
        WebElement regionElement = driver.findElement(By.xpath("//select[@id='region_list']"));
        Select regionSelect = new Select(regionElement);
        //Афон
        //regionSelect.selectByVisibleText("Афон");


        //selectByValue() выбирает все элементы с заданным значением value
        //28329 - его валью
        //regionSelect.selectByValue("28329");//value есть так же у того же класса option
        //если запустить одновременно 2 метода (regionSelect.selectByValue("28329")) и (regionSelect.selectByVisibleText("Афон");) то выберет их два


        //selectByIndex() выбор элемента по индексу. Индексирование начинается с нуля;
        //regionSelect.selectByIndex(4);


        //deselectByVisibleText(), deselectByValue(), deselectByIndex(), deselectAll
        //deselect- отменяют выбор элемента в зависимости от параметра
       /* regionSelect.deselectByIndex(4);
        Thread.sleep(2000);
        regionSelect.selectByIndex(4);
        Thread.sleep(2000);
        regionSelect.deselectByValue("28329");
        Thread.sleep(2000);
        regionSelect.selectByValue("28329");
        Thread.sleep(2000);
        regionSelect.deselectByVisibleText("Афон");
        Thread.sleep(2000);
        regionSelect.selectByVisibleText("Афон");
        Thread.sleep(2000);
        regionSelect.deselectAll();//убираем выбор со всего
        */


        //вводим isMultiple(); - если true, о поддерживает множ.выбор, если false - то нет
        //isMultiple(); возвращает true если данный select поддерживает множественный выбор
        WebElement hotelElement = driver.findElement(By.id("hotel_list"));
        Select hotelSelect = new Select(hotelElement);
        System.out.println(hotelSelect.isMultiple());
        System.out.println(countrySelect.isMultiple());
        //a[text()='Экскурсионные']
        driver.findElement(By.xpath("//a[text()='Экскурсионные']")).click();
        Thread.sleep(2000);
        Select cityListSelect = new Select(driver.findElement(Locators.city2));
        System.out.println(cityListSelect.isMultiple());



        //getOptions возвращает все элементы данного Select
        List<WebElement> cityList =  cityListSelect.getOptions();
        //System.out.println(cityList);
        /*for (WebElement city:cityList){
            if(city.getText().equals("Все города")){
                continue;
            }
            System.out.println(city.getText());
        }
*/

        //getAllSelectedOptions() возвращает все выбранные option из select
        cityListSelect.selectByVisibleText("Киев");
        cityListSelect.selectByVisibleText("Львов");
        cityListSelect.selectByVisibleText("Одесса");
        cityListSelect.deselectByVisibleText("Все города");
        System.out.println("===============");
        for(WebElement city: cityListSelect.getAllSelectedOptions()){
            System.out.println(city.getText());
        }
        System.out.println("================");

        //getFirstSelectedOptions() возвращает первый выбранный элемент
        System.out.println(cityListSelect.getFirstSelectedOption().getText());
        driver.quit();



        //equals сравнивание двух элементов
    }
}
