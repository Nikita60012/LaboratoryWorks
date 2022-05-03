import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyProgram {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку содержащую ip");
        String str = scanner.nextLine();
        System.out.println("Найден ip: " + FindIp(str));
    }
    public static String FindIp(String str){
        Pattern pattern= Pattern.compile("\\s(((25[0-5]|(2[0-4]\\d))|(1\\d{2})|(\\d{1,2}))\\.){3}((25[0-5]|(2[0-4]\\d))|(1\\d{2})|(\\d{1,2}))\\s");
        Matcher matcher = pattern.matcher(str);
        String ip = " ";
        if(matcher.find()){
            ip = matcher.group();
        }
        else{
            System.out.println("Ip не найден");
        }
        //192.168.15.130
        return ip;
    }
}
