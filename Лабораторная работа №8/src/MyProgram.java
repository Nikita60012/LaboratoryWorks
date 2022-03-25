import java.util.Scanner;

public class MyProgram {
    public static void main(String[] args){

        System.out.println("Введите 2 числа для примера c = (x+y)/(y+1)");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println("При введёных числах ответ будет равен: ");

        try {
            System.out.printf("%.4f", Calculation.getCalculation(x, y));
        } catch(MyException ex){
            System.out.println(ex.getMessage());
        }

    }
}
class Calculation{

    public static double getCalculation( int x, int y) throws MyException{

        double c;

        if(y+1 == 0){
            throw new MyException("Делить на 0 нельзя");
        }
            c = (double) (x + y) / (y + 1);
        return c;
    }
}
class MyException extends Exception{

    public MyException(String message){
        super(message);
    }
}
