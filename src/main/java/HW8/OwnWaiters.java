package HW8;

import lesson4.iframer.Iframes;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class OwnWaiters {
    private final WebDriver driver;// ожидания работают с драйвером поэтому создадим драйвер

    //далее создадим конструктор класса и его принимающие параметры (Driver)
    public OwnWaiters(WebDriver driver){
        this.driver=driver;
    }

    //Далее укажим значение наших ожиданий
    private static final long EXPLICITY_WAIT=20L;

    //далее создаем метод кот.возвращает экземпляр свободного ожидания

    private FluentWait<WebDriver> fluentWait(Long duration){//метод fluentWait принимает в параметры Long duration
        return new FluentWait<>(driver)//возвращаем
                .withTimeout(Duration.ofSeconds(duration))//какой промежуток времени нам нужно для ожидания условия
                .pollingEvery(Duration.ofSeconds(2))//наступление результата с какой частотой
                .ignoring(NoSuchElementException.class)//какие типы исключений будем игнорировать
                .ignoring(ElementNotInteractableException.class)//какие типы исключений будем игнорировать
                .ignoring(InvalidElementStateException.class)//какие типы исключений будем игнорировать
                .ignoring(StaleElementReferenceException.class);//какие типы исключений будем игнорировать
    }

    //создаем метод кот. будет ожидать функцию
    private void waitForFunction(Function function, Long timeout){
        FluentWait<WebDriver> wait = fluentWait(timeout);//прировняли два метода
        wait.until(function);
    }

    //Далее создаем наши методы явных ожиданий

    //1 presenceOfElementLocated() - ожидает появление элемента (работает только по локатору) НЕЛЬЗЯ ПЕРЕГРУЗИТЬ
    public void waitPresenceOfElementLocated(By by){
        waitForFunction(ExpectedConditions.presenceOfElementLocated(by),EXPLICITY_WAIT);
    }
    //ВОПРОС
    /*
    //перегружаю метод waitPresenceOfElementLocated
    public void waitPresenceOfElementLocated(WebElement element){
        waitForFunction(ExpectedConditions.presenceOfElementLocated(element),EXPLICITY_WAIT);
    }*/
    //добавляю в метод waitPresenceOfElementLocated возвращаемый тип значения WebElement
    public WebElement waitPresenceOfElementLocatedReturn(By by){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //2 textToBePresentInElementValue() - ожидает появление текста в элементе который надо вводить в него находящийся по заданному локатору
    //НЕЛЬЗЯ ДОБАВИТЬ ВОЗВРАЩ.ВЕБЭЛЕМЕНТ
    public void waitTextToBePresentInElementValue(WebElement element,String str){
        waitForFunction(ExpectedConditions.textToBePresentInElementValue(element,str),EXPLICITY_WAIT);
    }
    //перегружаем waitTextToBePresentInElementValue
    public void waitTextToBePresentInElementValue(By by,String str){
        waitForFunction(ExpectedConditions.textToBePresentInElementValue(by,str),EXPLICITY_WAIT);
    }

    //3 invisibilityOf() - ожидание видимости элемента (работает только по Вебэлементу)
    //НЕЛЬЗЯ ПЕРЕГРУЗИТЬ, НЕЛЬЗЯ ДОБАВИТЬ ВОЗВРАЩ.ВЕБЭЛЕМЕНТ
    public void waitInvisibilityOf(WebElement element){
        waitForFunction(ExpectedConditions.invisibilityOf(element),EXPLICITY_WAIT);
    }


    //4 - titleContains() - ожидание что в названии страницы находится указанный текст  (работает только со стринг)
    // НЕЛЬЗЯ ПЕРЕГРУЗИТЬ, НЕЛЬЗЯ ДОБАВИТЬ ВОЗВРАЩ.ВЕБЭЛЕМЕНТ
    public void waitTitleContains(String str){
        waitForFunction(ExpectedConditions.titleContains(str),EXPLICITY_WAIT);
    }


    //5 titleIs() - - ожидание указанного названия страницы (работает только со стринг)
    // НЕЛЬЗЯ ПЕРЕГРУЗИТЬ, НЕЛЬЗЯ ДОБАВИТЬ ВОЗВРАЩ.ВЕБЭЛЕМЕНТ
    public void waittitleIs(String str){
        waitForFunction(ExpectedConditions.titleIs(str),EXPLICITY_WAIT);
    }


    //6 elementToBeClickable()- ожидание кликабельности элемента
    public void waitElementToBeClickable(By by){
        waitForFunction(ExpectedConditions.elementToBeClickable(by),EXPLICITY_WAIT);
    }
    //перегружаем waitElementToBeClickable
    public void waitElementToBeClickable(WebElement element){
        waitForFunction(ExpectedConditions.elementToBeClickable(element),EXPLICITY_WAIT);
    }
    //добавляю в метод waitElementToBeClickable возвращаемый тип значения WebElement
    public WebElement waitElementToBeClickableReturn(By by){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(by));
    }
    //добавляю в метод waitElementToBeClickable возвращаемый тип значения WebElement
    public WebElement waitElementToBeClickableReturn(WebElement element){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(element));
    }


    //7 elementToBeSelected() -  ожидание чтобы элемент был выбран
    //НЕЛЬЗЯ ДОБАВИТЬ ВОЗВРАЩ.ВЕБЭЛЕМЕНТ
    public void waitElementToBeSelected(By by){
        waitForFunction(ExpectedConditions.elementToBeSelected(by),EXPLICITY_WAIT);
    }
    //перегружаем waitElementToBeSelected
    public void waitElementToBeSelected(WebElement element){
        waitForFunction(ExpectedConditions.elementToBeSelected(element),EXPLICITY_WAIT);
    }


    //8 elementSelectionStateToBe() -  ожидание от элемента быть или не быть выбранным
    //НЕЛЬЗЯ ДОБАВИТЬ ВОЗВРАЩ.ВЕБЭЛЕМЕНТ
    public void waitElementSelectionStateToBe(By by,boolean boo){
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(by,boo),EXPLICITY_WAIT);
    }
    //перегружаем waitElementSelectionStateToBe
    public void waitElementSelectionStateToBe(WebElement element,boolean boo){
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(element,boo),EXPLICITY_WAIT);
    }


    //9 visibilityOfElementLocated() -  ожидание видимости элемента (работает только по локатору)
    // НЕЛЬЗЯ ПЕРЕГРУЗИТЬ
    public void waitVisibilityOfElementLocated(By by){
        waitForFunction(ExpectedConditions.visibilityOfElementLocated(by),EXPLICITY_WAIT);
    }
    // добавляю в метод waitvisibilityOfElementLocated  возвращаемый тип данных WebElement
    public WebElement waitVisibilityOfElementLocatedReturn(By by){
       return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    //10 frameToBeAvailableAndSwitchToIt() -Ожидание доступности фрейма и переключение на него.
    //НЕЛЬЗЯ ДОБАВИТЬ ВОЗВРАЩ.ВЕБЭЛЕМЕНТ
    public void waitFrameToBeAvailableAndSwitchToIt(By by){
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by),EXPLICITY_WAIT);

    }
    //перегружаем waitFrameToBeAvailableAndSwitchToIt
    public void waitFrameToBeAvailableAndSwitchToIt(WebElement element){
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element),EXPLICITY_WAIT);
    }
    //перегружаем waitFrameToBeAvailableAndSwitchToIt
    public void waitFrameToBeAvailableAndSwitchToIt(String frameLocator){
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator),EXPLICITY_WAIT);

    }
    //перегружаем waitFrameToBeAvailableAndSwitchToIt
    public void waitFrameToBeAvailableAndSwitchToIt(int frameLocator){
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator),EXPLICITY_WAIT);

    }


    //11 alertIsPresent() - Ожидание появления алерта. (вообще не принимает никаких параметров)
    public void waitAlertIsPresent(){
        waitForFunction(ExpectedConditions.alertIsPresent(),EXPLICITY_WAIT);
    }


}
