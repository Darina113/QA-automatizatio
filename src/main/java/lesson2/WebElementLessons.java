package lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElementLessons {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        /*driver.get("https://www.guinnessworldrecords.com/search");
        WebElement acceptCookies = driver.findElement(By.xpath("//button[text() = 'Continue with Recommended Cookies']"));
        acceptCookies.click();

        WebElement searchField = driver.findElement(By.id("search-term"));
        searchField.sendKeys("Most handstand push ups");
        Thread.sleep(2000);
        searchField.clear();
        Thread.sleep(2000);
        searchField.sendKeys("Most pull ups");
        Thread.sleep(2000);
        searchField.sendKeys(Keys.ENTER);*/

 /*       driver.get("https://rozetka.com.ua/ua/");
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Я шукаю...']"));
        search.sendKeys("Samsung");
        Thread.sleep(4000);
        search.sendKeys(Keys.DOWN);
        Thread.sleep(4000);
        search.sendKeys(Keys.DOWN);
        Thread.sleep(4000);
        search.sendKeys(Keys.ENTER);*/

        //ChromeOptions options = new ChromeOptions();





        //getAttribute() получение значения атрибута элемента
        //getCssValue() получение значения заданного свойства CSS
        //getTagName() информация тэге выбранного элемента
        //getText() получение текста внктри элемента
        /*driver.get("https://rozetka.com.ua/ua/");
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Я шукаю...']"));
        WebElement buttonSearch = driver.findElement(By.cssSelector(".button.button_color_green.button_size_medium.search-form__submit.ng-star-inserted"));
        System.out.println(search.getAttribute("placeholder"));
        System.out.println(search.getCssValue("background-image"));
        System.out.println(buttonSearch.getTagName());
        System.out.println(buttonSearch.getText());
        driver.quit();*/







        //getLocation() местонахождение верхнего левого угла элемента
        //getSize() информация о ширине и высоте выбранного элемента
        driver.get("https://rozetka.com.ua/ua/");
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Я шукаю...']"));
        WebElement buttonSearch = driver.findElement(By.cssSelector(".button.button_color_green.button_size_medium.search-form__submit.ng-star-inserted"));
        System.out.println("Местонахождение верхнего левого угла элемента " + search.getLocation());
        System.out.println("Координата x верхнего левого угла элемента " + search.getLocation().x);
        System.out.println("Координата y верхнего левого угла элемента " + search.getLocation().y);

        System.out.println("Размер нашей кнопки "+ buttonSearch.getSize());
        System.out.println("Высота нашей кнопки "+ buttonSearch.getSize().height);
        System.out.println("Ширина нашей кнопки "+ buttonSearch.getSize().width);


        //isDisplayed(), isEnabled(), isSelected()
        //driver.get("https://www.guinnessworldrecords.com/Account/Login");


        //submit() - подтверждает действие.
        //driver.get("https://www.google.com");

    }
}
