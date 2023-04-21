package HW4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    private static class Url {
        private static final String first ="https://uhomki.com.ua/koshki/1074/";
        private static final String second ="https://itstep.dp.ua/ru";
        private static final String third ="https://www.w3schools.com/";
        private static final String fourth ="https://www.jetbrains.com/idea/";
        private static final String fifth ="https://www.jetbrains.com/idea/download/#section=windows";
    }
    private static class Name_locators {
        private static final By classuser = By.className("userbar__button-text");
        private static final By linkuser = By.linkText("Вход");
        private static final By xuser = By.xpath("//span[text()='Вход']");
        private static final By xdivuser = By.xpath("//div[contains(@class, 'user')]");
        private static final By catalog = By.xpath("//div[contains(@class, 'footer__heading')]");
        private static final By catalog2 = By.xpath("//a[@href=\"/ru/sobaki-koshki-obshchee/\"]");
        private static final By itspec = By.xpath("//h2[contains(text(), 'IT специальностям ')]");
        private static final By aqa = By.xpath("//span[contains(text(), 'Аквариумы')]");
        private static final By pyatoe = By.xpath("//div[contains(@class, 'dropbtn-phones')]/span");
        private static final By shestoe = By.xpath("//h2[contains(@class, 're-section-title re-home-adult__title')]");
        private static final By vosmoe = By.xpath("//h3[text()='Университет']/../../../div[1]/a/h3");
        private static final By devyatoe = By.xpath("//a[@href='/idea/download/']");

    }


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/darina/Desktop/selenium/chromedriver_mac64/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize(); //вызов большого окна

        // 1) Найти как можно кликнуть на кнопку "Вход" элемент используя 4
        //различных локатора(Это могут быть и 4 варианта xpath, нужно чтобы они отличались)

        //1.1
        /*driver.get(Url.first);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.className("userbar__button-text")).click(); //className - locator1
        Thread.sleep(2000);//замедляем действие
        driver.quit();*/
        //1.2
        /* driver.get(Url.first);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.linkText("Вход")).click(); //linktext - locator2
        Thread.sleep(2000);//замедляем действие
        driver.quit(); */
        //1.3
        // //span[text()='Вход']
       /* driver.get(Url.first);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.xpath("//span[text()='Вход']")).click();
        Thread.sleep(2000);//замедляем действие
        driver.quit(); */
        //1.4
        // //div[contains(@class, 'user')]
       /*  driver.get(Url.first);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.xpath("//div[contains(@class, 'user')]")).click();*/

        // 2) Найти элемент "Каталог", а при помощи него найти путь к элементу
        //"Собаки/кошки общее" используя xpath.
        // a[@href="/ru/sobaki-koshki-obshchee/"]
        /*driver.get(Url.first); //просим открыть конкретную ссылку
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.xpath("//div[contains(@class, 'footer__heading')]")).click();
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.xpath("//a[@href=\"/ru/sobaki-koshki-obshchee/\"]")).click();
        driver.quit();*/

        // 3)
        //Найти данный элемент по тексту "IT специальностям"
        ////h2[contains(text(), 'IT специальностям ')]
       /* driver.get(Url.second); //просим открыть конкретную ссылку
        Thread.sleep(2000);//замедляем действие
        System.out.println(
        driver.findElement(By.xpath("//h2[contains(text(), 'IT специальностям ')]")).getText());
        driver.quit();*/

        // 4) Найти путь к данному элементу
        //span[contains(text(), 'Аквариумы')]
        /* driver.get(Url.first);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.xpath("//span[contains(text(), 'Аквариумы')]")).click(); //клик тут не работает оставила просто для красивого вида
        Thread.sleep(4000);//замедляем действие
        driver.quit();*/

        // 5)
        //Найти путь к данному элементу не используя текст
        //div[contains(@class, 'dropbtn-phones')]/span
        /*driver.get(Url.second);
        Thread.sleep(2000);//замедляем действие
        System.out.println(
        driver.findElement(By.xpath("//div[contains(@class, 'dropbtn-phones')]/span")).getText());
        driver.quit();//закрываем окно */

        // 6)
        //Найти локатор данного элемента не используя текст
        ////h2[contains(@class, 're-section-title re-home-adult__title')]
        /*driver.get(Url.second);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.xpath("//h2[contains(@class, 're-section-title re-home-adult__title')]")).click();
        driver.quit();//закрываем окно*/

        // 7) https://www.w3schools.com/
        //найти 10 элементов на странице, для нахождения которых можно использовать
        //только айди и с которыми можно взаимодействовать. (Кликнуть, ввести текст и т.д.)

        //7.1
       /* driver.get(Url.third);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.id("search2")).sendKeys("HTML Tutorial");
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.id("learntocode_searchbtn")).click();
        Thread.sleep(2000);//замедляем действие
        driver.quit();//закрываем окно  */
        //7.2
       /* driver.get(Url.third);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.id("navbtn_tutorials")).click();
        Thread.sleep(2000);//замедляем действие
        driver.quit();//закрываем окно */
        //7.3
        /*driver.get(Url.third);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.id("navbtn_references")).click();
        Thread.sleep(2000);//замедляем действие
        driver.quit();//закрываем окно */
        //7.4
       /* driver.get(Url.third);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.id("navbtn_exercises")).click();
        Thread.sleep(2000);//замедляем действие
        driver.quit();//закрываем окно */
        //7.5
        /*driver.get(Url.third);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.id("cert_navbtn")).click();
        Thread.sleep(2000);//замедляем действие
        driver.quit();//закрываем окно */
        //7.6
        /*driver.get(Url.third);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.id("w3loginbtn")).click();
        Thread.sleep(5000);//замедляем действие
        driver.quit();//закрываем окно */
        //7.7
       /* driver.get(Url.third);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.id("signupbtn_topnav")).click();
        Thread.sleep(4000);//замедляем действие
        driver.quit();//закрываем окно */
        //7.8
       /* driver.get(Url.third);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.id("nav_search_btn")).click();
        Thread.sleep(4000);//замедляем действие
        driver.quit();//закрываем окно */
        //7.9
        /*driver.get(Url.third);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.id("nav_translate_btn")).click();
        Thread.sleep(3000);//замедляем действие
        driver.quit();//закрываем окно*/
        //7.10
        /*driver.get(Url.third);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.id("darkmodemenu")).click();
        Thread.sleep(2000);//замедляем действие
        driver.quit();//закрываем окно */

        // 8)
        //Отыскать один элемент на основе другого.
        //Для нахождения первого элемента можете использовать любые методы и локаторы,
        //для прописывания дальнейшего поиска второго элемента не использовать текст.
        //h3[text()='Университет']/../../../div[1]/a/h3
        /*driver.get(Url.second);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.xpath("//h3[text()='Университет']/../../../div[1]/a/h3")).click();
        Thread.sleep(2000);//замедляем действие
        driver.quit();//закрываем окно */

        // 9)
        // Найти данный элемент не используя текст. Используя только имя класса.
       /* driver.get(Url.fourth);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.xpath("//a[@href='/idea/download/']")).click();
        Thread.sleep(2000);//замедляем действие
        driver.quit();//закрываем окно */

        // 10)
        // найти локаторы к двум данным кнопкам.
        //Пользоваться любыми локаторами и методами.
        //10.1 (черная кнопка)
        // //a[contains(@href, '/idea/download/download-thanks.html?platform=windows&code=IIC')]
        /* driver.get(Url.fifth);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.xpath("//a[contains(@href, '/idea/download/download-thanks.html?platform=windows&code=IIC')]")).click();
        Thread.sleep(2000);//замедляем действие
        driver.quit();*/
        //10.2 (синяя кнопка)
        // //a[contains(@href, '/idea/download/download-thanks.html?platform=windows')]
        /*driver.get(Url.fifth);
        Thread.sleep(2000);//замедляем действие
        driver.findElement(By.xpath("//a[contains(@href, '/idea/download/download-thanks.html?platform=windows')]")).click();
        Thread.sleep(2000);//замедляем действие
        driver.quit();*/




















    }
}
