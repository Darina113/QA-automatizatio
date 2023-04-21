package HW5.Task3;
// 3)
// Написать метод который выводит сообщение об айди элемента,
//значении тэга элемента , значении класса элемента,
//значении атрибута name элемента, текста данного элемента,
//а также о координатах центра контейнера данного элемента.
//Создать свой тип исключений, который будет вызываться если у элемента
//нет определенного атрибута и на экран будет выводиться сообщение об отсутствии данного атрибута.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {

    public static void iskluchenie(WebElement element1) throws ZeroValID, ZeroValTagName, ZeroValClass, ZeroValName, ZeroValGetText {
        int centerW=element1.getSize().width/2;
        int centerH=element1.getSize().height/2;
        try {
            if (element1.getAttribute("id") == null) {
                throw new ZeroValID();
            } else {
                System.out.println("Значение Id элемента: \"" + element1.getAttribute("id"));
            }
            if (element1.getTagName() == null) {
                throw new ZeroValTagName();
            } else {
                System.out.println("Значение тэга элемента: " + element1.getTagName());
            }
            if (element1.getAttribute("class") == null) {
                throw new ZeroValClass();
            } else {
                System.out.println("Значение класса элемента: " + element1.getAttribute("class"));
            }
            if (element1.getAttribute("name") == null) {
                throw new ZeroValName();
            } else {
                System.out.println("Значение атрибута name элемента: " + element1.getAttribute("name"));
            }
            if (element1.getText() == null) {
                throw new ZeroValGetText();
            } else {
                System.out.println("Текст данного элемента: " + element1.getText());
            }
            /*if (element1.getSize()=null) {
                throw new ZeroValLocation();
            }else {
                System.out.println("Координаты центра контейнера " + centerW+" : "+centerH);
            }*/
        } catch (ZeroValID a) {
            System.out.println(a.getMEssege());
        } catch (ZeroValTagName a) {
            System.out.println(a.getMEssege());
        } catch (ZeroValClass a) {
            System.out.println(a.getMEssege());
        } catch (ZeroValName a) {
            System.out.println(a.getMEssege());
        } catch (ZeroValGetText a) {
            System.out.println(a.getMEssege());
        }
        System.out.println("Координаты центра контейнера " + centerW+" : "+centerH);
    }
}



