import java.util.Scanner;

public class MyProgram {
    public static void main(String[] args){
        System.out.println("Пример: z=(x+y)/(у+1)");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число x");
        int x = scanner.nextInt();

        System.out.println("Введите число y");
        int y = scanner.nextInt();

        Calculating calculation = new Calculating(x,y);
        calculation.primer();
    }
}
class Calculating{
    int x;
    int y;
    Calculating(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void primer(){

        if(y+1 == 0) {
            System.out.println("В делители получился 0, значит данные введены не корректно");
        }else {
            double z = (double) (x + y) / (y + 1);
            System.out.println("Ответом примера является число: ");
            System.out.format("%.4f", z);
        }
    }
}
