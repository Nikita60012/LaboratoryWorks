import java.util.Scanner;

public class MyProgram {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();
        System.out.println(Task.maxWord(words)+" является самым длинным словом в введёной строке");
    }
}
class Task{
    public static String maxWord(String words){
        String[] wordsArray = words.split("\\s");
        String max = " ";
        for(String word : wordsArray){
            if(max.compareToIgnoreCase(word) < 0){
                max = word;
            }
        }
        return max;
    }
}
