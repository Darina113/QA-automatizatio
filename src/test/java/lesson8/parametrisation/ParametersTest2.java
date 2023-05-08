package lesson8.parametrisation;

import lesson5.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ParametersTest2 {
    private static class Locators {
        private static final By openSearch = By.xpath("//div[@id='open-search']");
        private static final By searchField = By.xpath("//input[@placeholder='Пошук...']");
        private static final By entranceGoogle = By.xpath("//span[text()='Увійти через Google']");
        private static final By loginField
                = By.xpath("//input[@placeholder='Логін або Email']");
        private static final By passField = By.xpath("//input[@placeholder='Пароль']");
        private static final By checkBox = By.xpath("//i[@class='um-icon-android-checkbox-outline-blank']");
        private static final By SighInButton = By.xpath("//input[@value='Вхід']");
        private static final By LoginButton = By.xpath("//a[@class='um-button um-alt']");
        private static final By recept = By.xpath("//ul[@id='menu-main_menu_our-ua']//a[text()='Рецепти']");

        private static final By seerchResult = By.tagName("h2");
        private static final By otherDishes = By.xpath("//ul[@id='menu-main_menu_our-ua']//a[text()='Другі страви']");
        private static final By meat = By.xpath("//ul[@id='menu-main_menu_our-ua']//a[text()='" + Labels.meat + "']");
        private static final By fish = By.xpath("//ul[@id='menu-main_menu_our-ua']//a[text()='" + Labels.fish + "']");
        private static final By veg = By.xpath("//ul[@id='menu-main_menu_our-ua']//a[text()='" + Labels.vegs + "']");
        private static final By garnirs = By.xpath("//ul[@id='menu-main_menu_our-ua']//a[text()='" + Labels.garniers + "']");
        private static final By pixxa = By.xpath("//ul[@id='menu-main_menu_our-ua']//a[text()='" + Labels.pizza + "']");
        private static final By pasta = By.xpath("//ul[@id='menu-main_menu_our-ua']//a[text()='" + Labels.pasta + "']");

    }

    private static class Url {
        private static final String loginPage = "https://klopotenko.com/login/";
    }

    private static class Labels {
        private static final String LoginnText = "Зареєструватись";
        private static final String SighInText = "Вхід";
        private static final String loginPage = "https://www.guinnessworldrecords.com/Account/Login";
        private static final String PassFieldText = "Пароль";
        private static final String LoginFieldText = "Логін або Email";
        private static final String meat = "М’ясні";
        private static final String fish = "Рибне";
        private static final String vegs = "Овочеві";
        private static final String garniers = "Гарніри";
        private static final String pizza = "Піца";
        private static final String pasta = "Паста";
        private static final String GoogleSignInText = "Увійти через Google";
    }

    WebDriver driver;
    MyWaiters myWaiters;

    @BeforeClass
    public void driverInitialisation() {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        driver = new ChromeDriver();
        myWaiters = new MyWaiters(driver);
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/");
        new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//a[@aria-label='dismiss cookie message']")).click();
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

    @Test
    @Parameters({"input","equals"})//передали 2 параметра(придумали тут), а саму настройку делаем в NG файле testngParameters2.xml
    public void searchTest2(String searchParams,String result) {//передали 2 параметра(название придумали тут)
        driver.get(Url.loginPage);
        myWaiters.waitPresenceOfElement(Locators.entranceGoogle);
        driver.findElement(Locators.openSearch).click();
        WebElement searchField = myWaiters.waitVisabilityOfWebElentReturn(Locators.searchField);
        searchField.sendKeys(searchParams);
        searchField.submit();
        WebElement resultSearch = myWaiters.waitPresenceOfElementReturn(Locators.seerchResult);
        String resultText = resultSearch.getText().replace("ЗНАЙДЕНО ЗА ЗАПИТОМ: ", "");
        assertTrue(resultText.equals(result));
    }
}
