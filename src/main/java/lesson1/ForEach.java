package lesson1;

public class ForEach {
    public static void main(String[] args) {
        int[] array = {2,3,24,124,124,44,4,5};
        for(int number:array){
            System.out.print(number +" ");
        }
        System.out.println("\n=======");
        for(int i =0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
