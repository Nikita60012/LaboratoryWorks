import java.util.Scanner;

public class ProgramMain {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        double x = 0;
        boolean range = false;
        System.out.println("Введите число x в диапазоне от -1 до 1 (включая -1)");
        System.out.println("(Для ввода дробных чисел используйте знак , )");

        while (!range){
            x = scanner.nextDouble();
            if(x >= -1 & x < 1) {
                range = true;
            }else{
                System.out.println("Введено число, не входящее в указаный диапазон, введите ещё раз");
            }
        }

        System.out.println("Введите количество итерации от 1 и более");
        int n = 0;
        range = false;
        while(!range) {
            n = scanner.nextInt();
            if (n >= 1) {
                range = true;
            } else {
                System.out.println("Вы ввели недопустимое количество итерации, введите ещё раз");
            }
        }

        double sum = 0;
        for(int i = 1; i <= n; i++){
            sum += (Math.pow(x,i))/i;
        }
        sum = sum * -1;
        System.out.println("Ответ: ");
        System.out.format("%.4f",sum);
    }
}
