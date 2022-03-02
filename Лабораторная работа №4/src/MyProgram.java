import java.util.Random;

public class MyProgram {
    public static void main(String[] args){

        Random random = new Random();
        int length = random.nextInt(2,11);
        System.out.println("Размерность массива равна " + length);

        int[] myArray = new int[length];
        System.out.println("Состав массива: ");

        for(int i = 0; i < length; i++){
            myArray[i]= random.nextInt(1,101);
            System.out.print(myArray[i]+" ");
        }

        System.out.println();

        int min = 102;
        double sum = 0;

        for(int i = 0; i < length; i++){
            if(myArray[i] < min)
                min = myArray[i];
            sum += myArray[i];
        }

        sum /= length;
        sum += min;
        System.out.println("Сумма минимального элемента и среднего арифметического равна "+ sum);
    }
}