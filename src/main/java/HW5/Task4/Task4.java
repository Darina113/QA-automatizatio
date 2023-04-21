package HW5.Task4;
// 4)
// https://uhomki.com.ua/
//Написать метод, который будет выводить в консоль тексты всех
//элементов, которые можно найти по заданнму параметру.
//Например при помощи него можно будет получить значения всех элементов
//из списков заданных на "Рисунок 4.png" и "Рисунок 5.png".

import org.openqa.selenium.WebElement;

import java.util.List;

public class Task4 {
    public static void vivodInfo(WebElement element1, List<WebElement> element2){
        System.out.println("Рисунок 4.png: \n"+element1.getText());
        for (int i = 0; i < element2.size(); i++) {
            System.out.println("Рисунок 5.png. \n"+element2.get(i).getText());
        }
    }
}
