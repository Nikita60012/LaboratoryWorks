import java.util.Scanner;

class Animal{

    String food;
    String location;

    Animal(String food, String location){
        this.food = food;
        this.location = location;
    }
    public void makeNoise(){
        System.out.println("храпит");
    }
    public void eat(){
        System.out.println("голодный");
    }
    public void sleep(){
        System.out.println("спит");
    }
}
public class MyProgram {
    public static void main(String[] args){

        System.out.println("Выберите  цифру одного из следующих животных (1, 2 или 3): Собака, Кот, Лошадь");

        Scanner scanner = new Scanner(System.in);
        int type_animal = scanner.nextInt();

        if(type_animal == 1) {
            Dog dog = new Dog("Куриные лапки", "Будка");
            dog.eat();
            dog.sleep();
            dog.makeNoise();
            dog.health();
        }
        else if(type_animal == 2) {
            Cat cat = new Cat("Рыбка", "Дом");
            cat.eat();
            cat.sleep();
            cat.makeNoise();
            cat.health();
        }
        else if(type_animal == 3) {
            Horse horse = new Horse("Морковь", "Сарай");
            horse.eat();
            horse.sleep();
            horse.makeNoise();
            horse.health();
        }
    }
}
class Dog extends Animal{
    Dog(String food, String location){
        super(food, location);
    }
    private String unique_factor = "Любимая игрушка - резиновая косточка";

    public void eat(){
        System.out.println("Собака ела утром");
        System.out.println(unique_factor);
    }

    public void sleep(){
        System.out.println("Собака спит");
    }

    public void makeNoise(){
        System.out.println("Храпит");
    }

    public void health(){
        Animal dog = new Dog(food, location);
        System.out.println("Собака на приёме у ветеринара");
        Veterinar veterinar = new Veterinar();
        veterinar.treatAnimal(dog);
    }
}
class Cat extends Animal{

    private String unique_factor = "Любимое место сна - диван";

    Cat(String food, String location){
        super(food, location);
    }

    public void eat(){
        System.out.println("Кот поел недавно");
    }

    public void sleep(){
        System.out.println("Кот сонный");
        System.out.println(unique_factor);
    }

    public void makeNoise(){
        System.out.println("Зевает");
    }

    public void health(){
        Animal cat = new Cat(food, location);
        System.out.println("Кот на приёме у ветеринара");
        Veterinar veterinar = new Veterinar();
        veterinar.treatAnimal(cat);
    }
}
class Horse extends Animal{

    private String unique_factor = "Быстро скачет";

    Horse(String food, String location){

        super(food, location);

    }
    public void eat(){
        System.out.println("Лошадь ест");
    }

    public void sleep(){
        System.out.println("Лошадь не спит");
    }

    public void makeNoise(){
        System.out.println("Чавкает");
    }

    public void health(){
        System.out.println(unique_factor);
        Animal horse = new Horse(food, location);
        System.out.println("Лошадь на приёме у ветеринара");
        Veterinar veterinar = new Veterinar();
        veterinar.treatAnimal(horse);
    }
}

class Veterinar{
    public void treatAnimal(Animal animal){
        System.out.println("Любимая еда это " + animal.food);
        System.out.println("Место жительства это "+ animal.location);
    }
}