package lesson2.exceptionist;

public class NegativeValueException extends Exception {
    public String getMessage(){
        return "Это отрицательный результат";
    }
}
