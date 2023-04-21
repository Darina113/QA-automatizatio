package HW5.Task2;
// 2)
//Написать метод в параметры которого принимаются два ВебЭлемента.
//метод выводит в консоль информацию какой из двух элементов располагается  выше на странице,
//какой из элементов располагается левее на странице,
//а также какой из элементов занимает большую площадь.
//Параметры метода могут также включать в себя другие аргументы, если это необходимо.

import org.openqa.selenium.WebElement;

public class Task2 {
    public static void vivodLoc(WebElement element1,WebElement element2){
        System.out.println("Координаты первого элемента "+element1.getLocation());
        System.out.println("Координаты второго элемента "+element2.getLocation());

        //какой из элементов располагается левее на странице
        if (element1.getLocation().getX()<element2.getLocation().getX()){
            System.out.println("Левее на странице первый элемент "+element1.getLocation().getX());
        } else if (element1.getLocation().getX()>element2.getLocation().getX()){
            System.out.println("Левее на странице второй элемент "+element2.getLocation().getX());
        } else System.out.println("Одинаковы");


        //какой из элементов располагается выше на странице
        if (element1.getLocation().getY()<element2.getLocation().getY()){
            System.out.println("Выше на странцие первый элемент "+element1.getLocation().getY());
        } else if (element1.getLocation().getY()>element2.getLocation().getY()) {
                System.out.println("Выше на странице второй элемент "+element2.getLocation().getY());
        } else System.out.println("Высота одинакова");

        //площадь
        int s1,s2;
        s1=element1.getSize().height*element1.getSize().width;
        s2=element2.getSize().height*element2.getSize().width;
        System.out.println("Высота и ширина первого элемента "+element1.getSize());
        System.out.println("Высота и ширина второго элемента "+element2.getSize());

        if (s1>s2){
            System.out.println("Площадь первого элемента = "+s1+" и она больше второго элемента");
        } else {
            System.out.println("Площадь второго элемента= "+s2+" и он больше первого элемента");
        }
    }
}
