import java.util.Random;

public class MyProgram {
    public static void main(String[] args){

        //Вариант 6. Написать программу,
        //сортирующую по возрастанию одномерный массив случайных целых чисел. Использовать сортировку выбором.

        Random random = new Random();
        int length = random.nextInt(2,10);
        System.out.println("Размерность массива равна " + length);
        int[] myArray = new int[length];

        System.out.println("Состав массива: ");
        for(int i = 0; i < length; i++){
            myArray[i] = random.nextInt(0,101);
            System.out.print(myArray[i]+" ");
        }
        System.out.println();
        System.out.println("Отсортированный состав массива: ");
        for(int i = 0; i < length; i++){
            myArray[i] = InsertionSort(myArray)[i];
            System.out.print(myArray[i]+" ");
        }
    }
    public static int[] InsertionSort(int[] myNewArray) {
        for (int i = 0; i < myNewArray.length; ++i) {
            int x = myNewArray[i];
            int j = i;
            while (j > 0 && myNewArray[j - 1] > x) {
                myNewArray[j] = myNewArray[j - 1];
                --j;
            }
            myNewArray[j] = x;
        }
        return myNewArray;
    }
}
