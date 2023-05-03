package lesson7;

import lesson5.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class AssertionExTests {
    WebDriver driver;
    //анотация стала доступной т.к. мы прописали зависимость TestNG в доке pom.xml,
    // а саму зависимость взяли с ссылки https://mvnrepository.com/artifact/org.testng/testng/7.7.1

    @BeforeClass//перед запуском всего класса будет запускаться сначала этот метод BeforeClass,после остальные  методы (тесты) будут происходить
    public void driverInitialisation() {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/");
        new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//a[@aria-label='dismiss cookie message']")).click();
    }

    @AfterClass//после прохождения всех методов(тестов) сработает этот метод AfterClass
    public void closeDriver() {
        driver.quit();
    }

    @Test //напишем тест кот. будет проверять название страницы
    public void checkWebPageTitle() {
        driver.get("https://klopotenko.com/");
        String pageTitle = "Євген Клопотенко - Кулінарні рецепти від Євгена Клопотенка";
        String pageTitle2 = "Євген Клопотенкwо - Кулінарні рецепти від Євгена Клопотенка";
        String partOfTitle = "Євген Клопотенко";
        new MyWaiters(driver).waitTitleContainsText(partOfTitle); //обращаемся к классу с собственными методами. исп.метод который проверяет наличие текста
        // assert - это проверка
        //assertTrue - это проверка,если внутри скобок будет выражение истина, т.е. возвращаться true, то тогда тест будет проходить
        //assertTrue если getTitle будет эквивалентно pageTitle то тест пройдет, так как название страницы будет равно нашему pageTitle
        assertTrue(driver.getTitle().equals(pageTitle), "Название не соответствует ожидаемому");
        //assertFalse -работает наоборот, если внутри передан false
        assertFalse(driver.getTitle().equals(pageTitle2), "Название соответствует ожидаемому");
        //assertEquals - при помощи него можно проверять элементы на соответсвие
        //driver.getTitle() - название которое есть, pageTitle - название которое мы ожидаем. если везде будет совпадение то тест пройдет
        assertEquals(driver.getTitle(), pageTitle, "Название не соответствует ожидаемому.\n" +
                "Я ожидал " + pageTitle + " а получил " + driver.getTitle());

        //assertNotEquals - работает наоборот
        assertNotEquals(driver.getTitle(), pageTitle2, "Название не соответствует ожидаемому.\n" +
                "Я ожидал " + pageTitle2 + " а получил " + driver.getTitle());
    }


    @Test
    public void functionOfChecBox() throws InterruptedException {
        driver.get("https://klopotenko.com/");
        new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//span[text()='ВХІД']")).click();
        new MyWaiters(driver).waitTitleContainsText("Вхід - Klopotenko");
        assertEquals(driver.getTitle(), "Вхід - Klopotenko");
        WebElement unclicked = new MyWaiters(driver).waitPresenceOfElementReturn
                (By.xpath("//i[@class='um-icon-android-checkbox-outline-blank']"));
        assertTrue(unclicked.isDisplayed());//проверим что кнопка отображается

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,200)");// у объекта вызываем метод выполни скрипт, и отскроль страницв вниз

        unclicked.click();

        //далее проверим что кнопка такая появилась на экране  1 вар.записи
        assertTrue(
                new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//i[@class='um-icon-android-checkbox-outline']"))
                        .isDisplayed()
        );
        // 2 вар. записи
        driver.findElement(By.xpath("//i[@class='um-icon-android-checkbox-outline']")).click();

        assertTrue(
                new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//i[@class='um-icon-android-checkbox-outline-blank']"))
                        .isDisplayed()
        );
    }

    @Test
    public void countOfIngridients() {
        driver.get("https://klopotenko.com/sparzha-z-sousom-beshamel/");
        assertEquals(driver.findElement(By.xpath("//h4[text()='Для спаржі:']")).getText(),
                "Для спаржі:");
        assertEquals(driver.findElement(By.xpath("//h4[text()='Для бешамель:']")).getText(),
                "Для бешамель:");

        List<WebElement> sparza = driver.findElements(By.xpath("//h4[text()='Для спаржі:']/following-sibling::div/div//label"));
        assertTrue(sparza.size() == 4, "Кол-во ингридиентов не совпадает с ожиданием");//проверяем сколько элементов у "листа" sparza(он общий,кот.вкл в себя список), ожидали 4

        List<WebElement> beshamel = driver.findElements(By.xpath("//h4[text()='Для бешамель:']/following-sibling::div/div//label"));
        assertTrue(beshamel.size() == 5, "Кол-во ингридиентов не совпадает с ожиданием");//проверяем сколько элементов у "листа" beshamel (он общий,кот.вкл в себя список), ожидали 5
        String[] labelsSparza = {"500 г спаржі", "30 г вершкового масла", "сік чверті лимона", "сіль за смаком"};//создаем массив из перечня текста, в элементах которые выше
        //запускаем цикл, где будем проверять идентичность названий каждого элемента
        for (int i = 0; i < sparza.size(); i++) {
            assertEquals(sparza.get(i).getText(), labelsSparza[i]);
        }

        String[] labelsBeshamel = {"30 г вершкового масла", "30 г борошна пшеничного", "300 мл молока", "за смаком сіль", "дрібка мускатного горіха"};//создаем массив из перечня текста, в элементах которые выше
        //запускаем цикл, где будем проверять идентичность названий каждого элемента
        for (int i = 0; i < beshamel.size(); i++) {
            assertEquals(beshamel.get(i).getText(), labelsBeshamel[i]);
        }
    }
}
