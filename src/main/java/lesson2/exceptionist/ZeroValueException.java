package lesson2.exceptionist;

public class ZeroValueException extends Exception {
    public String getMessage(){
        return "Значение числа ноль";
    }
}
