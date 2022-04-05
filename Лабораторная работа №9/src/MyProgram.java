import java.util.InputMismatchException;
import java.util.Scanner;

interface Product{
    void name();
    void cost();
    void rate();
}
interface  User{
    void login();
    void password();
}
public class MyProgram {
    public static void main(String[] args){

        BuyList buyList = new BuyList();

        System.out.println("Выберите пользователя: Василий, Михаил, Пётр (1, 2, 3)");

        //Обращение к классу реализуещему оба интерфейса и связывающего всё воедино
        buyList.login();
        buyList.password();
        buyList.name();
        buyList.cost();
        buyList.rate();
            /*
            1
            Login: Vasiliy1234
            Password: 1234
            2
            Login: Michail4321
            Password: 4321
            3
            Login: Petr2314
            Password: 2314
             */
    }
}

//реализация трёх классов, наследующих интерфейс Product
class Sugar implements Product{
    public void name(){
        System.out.println("Сахар");
    }
    public void cost(){
        System.out.print("80 руб./кг.");
    }
    public void rate(){
        double rate = (Math.random()*10);
        System.out.printf("%.1f  звёзд",rate);
    }
}
class Apples implements Product{
    public void name(){
        System.out.println("Яблоки");
    }
    public void cost(){
        System.out.print("120 руб./кг.");
    }
    public void rate(){
        double rate = (Math.random()*10);
        System.out.printf("%.1f  звёзд",rate);
    }
}
class AppleJem implements Product{
    public void name(){
        System.out.println("Яблочный джем");
    }
    public void cost(){
        System.out.print("150 руб./кг.");
    }
    public void rate(){
        double rate = (Math.random()*10);
        System.out.printf("%.1f  звёзд",rate);
    }
}

//реализация трёх классов, наследующих интерфейс User
class Vasiliy implements User{

    private boolean login = false;
    private boolean password = false;

    public void login(){
        System.out.println("Введите ваш логин");
        String log;
        while (!login) {
            Scanner scanner = new Scanner(System.in);
            log = scanner.next();
            if (log.equals("Vasiliy1234")) {
                login = true;
                System.out.println("Здравствуйте Василий");
            } else {
                System.out.println("Вы ввели не правильный логин, введите ещё раз");
            }
        }
    }
    public void password(){

        System.out.println("Введите ваш пароль");
        String pas;
        while (!password) {
            Scanner scanner = new Scanner(System.in);
            pas = scanner.next();
            if (pas.equals("1234")) {
                password = true;
                System.out.println("Вы ввели правильный пароль");
            }else{
                System.out.println("Вы ввели не правильный пароль, введите ещё раз");
            }
        }
    }
}
class Michail implements User{
    private boolean login = false;
    private boolean password = false;
    public void login() {
        System.out.println("Введите ваш логин");
        String log;
        while (!login) {
            Scanner scanner = new Scanner(System.in);
            log = scanner.next();
            if (log.equals("Michail4321")) {
                login = true;
                System.out.println("Здравствуйте Михаил");
            } else {
                System.out.println("Вы ввели не правильный логин, введите ещё раз");
            }
        }
    }
    public void password(){
        System.out.println("Введите ваш пароль");
        String pas;
        while (!password) {
            Scanner scanner = new Scanner(System.in);
            pas = scanner.next();
            if (pas.equals("4321")) {
                password = true;
                System.out.println("Вы ввели правильный пароль");
            }else{
                System.out.println("Вы ввели не правильный пароль, введите ещё раз");
            }
        }
    }
}
class Petr implements User{
    private boolean login = false;
    private boolean password = false;
    public void login(){
        System.out.println("Введите ваш логин");
        String log;
        while (!login) {
            Scanner scanner = new Scanner(System.in);
            log = scanner.next();
            if (log.equals("Petr2314")) {
                login = true;
                System.out.println("Здравствуйте Пётр");
            }else {
                System.out.println("Вы ввели не правильный логин, введите ещё раз");
            }
        }
    }
    public void password(){
        System.out.println("Введите ваш пароль");
        String pas;
        while (!password) {
            Scanner scanner = new Scanner(System.in);
            pas = scanner.next();
            if (pas.equals("2314")) {
                password = true;
                System.out.println("Вы ввели правильный пароль");
            }else{
                System.out.println("Вы ввели не правильный пароль, введите ещё раз");
            }
        }
    }
}

//реализация класса, наследующего оба интерфейса
class BuyList implements User, Product{
    Scanner scanner = new Scanner(System.in);
    int choice;
    String[] nameArray = new String[]{"Николай", "Андрей","Артём","Дмитрий","Константин"};
    int nameChoice;
    boolean accountChoice = false;
    boolean excep;

    Vasiliy vasya = new Vasiliy();
    Michail michail = new Michail();
    Petr petr = new Petr();
    Sugar sugar = new Sugar();
    Apples apples = new Apples();
    AppleJem appleJem = new AppleJem();

    public void login(){

        //проверка на корректность выбора аккаунта
        while (!accountChoice) {
            excep = false;
            try {
                choice = scanner.nextInt();
            }catch(InputMismatchException ex){
                System.out.println("Вы сделали некорректный выбор, выберите ещё раз");
                scanner = new Scanner(System.in);
                excep = true;
            }
            if (choice == 1) {
                vasya.login();
                accountChoice = true;
            } else if (choice == 2) {
                michail.login();
                accountChoice = true;
            } else if (choice == 3) {
                petr.login();
                accountChoice = true;
            } else {
                if(!excep) {
                    System.out.println("Вы выбрали несуществующий аккаунт, выберите ещё раз");
                }
            }
        }
    }
    public void password(){
        if(choice == 1){
            vasya.password();
        }
        else if(choice == 2){
            michail.password();
        }
        else if(choice == 3){
            petr.password();
        }
    }
    public void name(){
        //случайным образом выбирается покупатель из массива имён, товар, что он купил и оценку, которую он поставил (от 1 до 10)
        nameChoice = (int)(Math.random()*5);
        System.out.println(nameArray[nameChoice]+" купил:");
        choice = (int)(Math.random()*3)+1;
        if(choice == 1){
            sugar.name();
        }
        else if(choice == 2){
            apples.name();
        }
        else if(choice == 3){
            appleJem.name();
        }
    }
    public void cost() {
        if(choice == 1){
            System.out.print("По: ");
            sugar.cost();
        }
        else if(choice == 2){
            System.out.print("По: ");
            apples.cost();
        }
        else if(choice == 3){
            System.out.print("По: ");
            appleJem.cost();
        }
    }
    public void rate() {
        if(choice == 1){
            System.out.println();
            System.out.print("Поставил оценку: ");
            sugar.rate();
        }
        else if(choice == 2){
            System.out.println();
            System.out.print("Поставил оценку: ");
            apples.rate();
        }
        else if(choice == 3){
            System.out.println();
            System.out.print("Поставил оценку: ");
            appleJem.rate();
        }
    }
}