package lesson2.exceptionist;

import java.util.Scanner;

public class exampleExeption {
    public static void division(int x) throws ZeroValueException, NegativeValueException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите знаменатель:");
        int i = scanner.nextInt();
        if(i==0){
            throw new ZeroValueException();
        }
        if (x/i<0){
            throw new NegativeValueException();
        }
        System.out.println(x/i);
    }
    public static void division2(int x) throws ZeroValueEx, NegativeVal {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите знаменатель:");
        int i = scanner.nextInt();
        if(i==0){
            throw new ZeroValueEx("Это значение ноль");
        }
        if (x/i<0){
            throw new NegativeVal("Это отрицательное значение");
        }
        System.out.println(x/i);
    }

    public static void main(String[] args) {
       /* try{
            division(9);
        }catch(ZeroValueException e){
            System.out.println(e.getMessage());
        }catch (NegativeValueException e){
            System.out.println(e.getMessage());
        }*/
       /* try {
            division(12);
        }catch (ZeroValueException|NegativeValueException e){
            System.out.println(e.getMessage());
        }*/
        try {
            division2(12);
        }catch (ZeroValueEx|NegativeVal exception){
            System.out.println(exception.getMessage());
        }

    }
}
