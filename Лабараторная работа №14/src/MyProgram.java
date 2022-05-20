import java.io.*;
import java.util.Scanner;

public class MyProgram {
    public static void main(String[] args){

        String input;
        Scanner scanner = new Scanner(System.in);
        double x;
        Calculate calc = new Calculate();

        System.out.println("Введите значение числа х или одну из доступных команд: check, save, upload, exit");
        boolean inProgress = true;
        while (inProgress) {
            input = scanner.nextLine();
            try{
                x = Double.parseDouble(input);
                calc.calculating(x);
            }catch (Exception exception) {
                if ("check".equals(input)) {
                    System.out.println("Текущее состояние переменных: x = " + calc.x + " y = " + calc.y);

                } else if ("save".equals(input)) {
                    try (ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("saved"))) {
                        save.writeObject(calc);
                        System.out.println("Состояние сохранено");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                } else if ("upload".equals(input)) {
                    try (ObjectInputStream upload = new ObjectInputStream(new FileInputStream("saved"))) {
                        calc = (Calculate) upload.readObject();
                        System.out.println("Состояние восстановлено");
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if ("exit".equals(input)) {
                    System.out.println("Произведён выход из программы");
                    inProgress = false;
                } else {
                    System.out.println("Введена неизвестная команда, введите ещё раз");
                }
            }
        }
    }
}
class Calculate implements Serializable{
    double x;
    double y;
    Calculate(){
        x = 0;
        y = 0;
    }
    void calculating(double x){
        this.x = x;
        y = x - Math.sin(x);
        System.out.println("Значение выражения равно " + y);
    }
}