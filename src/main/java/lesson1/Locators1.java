package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Locators1 {

    private static class Locators {
        private static final By acceptCookies = By.id("ez-accept-all");
        private static final By loginField = By.xpath("//input[@data-val-length-max!=100]");
        private static final By passswordField = By.xpath("//input[@data-val-length-max<=100]");
        private static final By linkToTextContainsWorld
                = By.xpath("//a[text()='Apply now']/parent::div/../div[2]//a[contains(text(), 'World')]");
        private static final By searchHomiak = By.name("q");
        private static final By arrayList = By.xpath("//h5[text()='PRODUCTS']/following-sibling::ul//a");
        private static final By arrayList2 = By.xpath("//h5[text()='RECORDS']/following-sibling::ul//a");

    }

    private static class Url {
        private static final String applyToSet = "https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/";
        private static final String homiak = "https://uhomki.com.ua/ru/";
        private static final String loginPage ="https://www.guinnessworldrecords.com/Account/Login";
    }
    private static void arraySout(List<WebElement> elementList){
        for (WebElement element: elementList){
            System.out.println(element.getText());
        }
    }


    public static void main(String[] args) throws InterruptedException {
//driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
//driver.findElement(By.id("ez-accept-all")).click();
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//Поиск элемента по id
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        //ez-accept-all
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("globe")).click();

//Поиск элемента по name
       /* driver.get("https://uhomki.com.ua/ru/");
        driver.findElement(By.name("q")).sendKeys("Хомяк");*/
        //search_uid8ab047eda7a35f9338d17d09dfe9697a
        //search_uidbaa516652c79171e4a81c853557631c6

//Поиск элемента по Class Name
        //useraccount2 orange-background
      /*  driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        //ez-accept-all
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("green-background")).click();*/
        //driver.findElement(By.xpath("//a[@class='green-background']")).click();

//Поиск элемента по Tag Name
        driver.get("https://www.guinnessworldrecords.com/search");
        //ez-accept-all
        //driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        driver.findElements(By.tagName("input")).get(1).sendKeys("Наш поиск");

       /* for(WebElement element:
        driver.findElements
                (By.xpath("//h5[text()='PRODUCTS']/following-sibling::ul//a"))){
            System.out.println(element.getText());
        }
        List<WebElement> elements = driver.findElements
                (By.xpath("//h5[text()='PRODUCTS']/following-sibling::ul//a"));
        for (int i=0;i<elements.size();i++){
            System.out.println("Текст элемента "+i +": "+elements.get(i).getText());
        }
        driver.quit();*/

//Поиск элемента по Link Text
       /* //APPLICATION PROCESS
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        //ez-accept-all
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("APPLICATION PROCESS")).click();
        Thread.sleep(3000);
        driver.quit()*/;
//Поиск элемента по Partial Text
        /*driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        //ez-accept-all
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("APPLICATION")).click();
        Thread.sleep(3000);
        driver.quit();*/

//Xpath //имя_тега[@атрибут='значение']
//input[@placeholder='поиск товаров']
/*        driver.get("https://uhomki.com.ua/ru/");
        driver.findElement(By.xpath("//input[@placeholder='поиск товаров']")).sendKeys("Хряк");
        driver.findElement(By.xpath("//input[@placeholder='поиск товаров']")).submit();*/

//xpath поиск по тексту
//xpath поиск по части текста. Метод contains
       /* driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        //ez-accept-all
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        //xpath поиск по части текста. Метод contains
        System.out.println(
        driver.findElement(By.xpath
                ("//p[contains(text(), 'ot what it takes to b')]")).getText());
        //xpath поиск по тексту
        driver.findElement(By.xpath("//a[text()='Standard application']")).click();
        Thread.sleep(2000);
        driver.quit();*/




//xpath поиск по части атрибута. комбинирование
 /*       driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        //ez-accept-all
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        driver.findElement
                (By.xpath("//div[contains(@class, 'block block-4-12')][not(contains(@class, 'columned'))]")).click();*/



//относительный путь внутри относительного пути
    /*    driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        //ez-accept-all
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        driver.findElement
                (By.xpath("//section[@class='simple-intro-wrapper component-wrapper design-two']//a[@class='btn']")).click();
*/


//xpath передвижение по DOM дереву
// /.. - вверх по тегу
// /имя_тега вниз к указанному тегу
//  переход на родительский тег /parent::div
// переход на доченрний тег /child::a
// переход на параллельный тег /following-sibling::*[1]
// предок /ancestor::span
// /descendant::h3

/*        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        //ez-accept-all
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        System.out.println(
        driver.findElement
                (By.xpath
                        ("//a[text()='Apply now']/parent::div/../div[2]//a[contains(text(), 'World')]"))
                .getText());

//xpath ключевые слово last(), указание порядкового номера
        System.out.println(driver.findElement(By.xpath
                ("//*[@class='columned block block-4-12'][last()]/a")).getText());

        System.out.println(driver.findElement(By.xpath
                ("//*[@class='columned block block-4-12'][2]/a")).getText());*/






//xpath операторы >, <, >=, <=, !=
//input[@data-val-length-max<=100] - password
        //input[@data-val-length-max!=100] - login
          /*     driver.get("https://www.guinnessworldrecords.com/Account/Login");
        //ez-accept-all
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@data-val-length-max!=100]"))
                .sendKeys("Это поле Логина");
        driver.findElement(By.xpath("//input[@data-val-length-max<=100]"))
                .sendKeys("Это поле Пароля");*/

        //Использование вложенного класса Url, Locator
        /*driver.get(Url.loginPage);
        //ez-accept-all
        driver.findElement(Locators.acceptCookies).click();
        Thread.sleep(2000);
        driver.findElement(Locators.loginField)
                .sendKeys("Это поле Логина");
        driver.findElement(Locators.passswordField)
                .sendKeys("Это поле Пароля");
        Thread.sleep(2000);

        driver.navigate().to(Url.applyToSet);
        Thread.sleep(2000);
        System.out.println(driver.findElement(Locators.linkToTextContainsWorld).getText());
        Thread.sleep(2000);

        driver.navigate().to(Url.homiak);
        driver.findElement(Locators.searchHomiak).sendKeys("Хомяк");*/



        //использование статического метода
    /*    driver.get("https://www.guinnessworldrecords.com/search");
        //ez-accept-all
        driver.findElement(By.id("ez-accept-all")).click();
        Thread.sleep(2000);

        List<WebElement> elements = driver.findElements(Locators.arrayList);
        List<WebElement> elements2 = driver.findElements(Locators.arrayList2);

        arraySout(elements);
        System.out.println("");
        arraySout(elements2);
        driver.quit();*/




    }
}
