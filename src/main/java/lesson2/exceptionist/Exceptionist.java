package lesson2.exceptionist;

import java.util.Scanner;

public class Exceptionist {
    public static void main(String[] args) {
        /*int[] array = {12,23,12,2};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите индекс элемента, для вывода в консоль:");
        int i = scanner.nextInt();
        try {

            if(i>4){
                throw new ArithmeticException("Вы вышли за пределы массива");
            }
        }catch (ArithmeticException e){
            e.getMessage();
        }
        System.out.println(array[i]);*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите знаменатель:");
        int i = scanner.nextInt();
        System.out.println(12/i);

    }
}
