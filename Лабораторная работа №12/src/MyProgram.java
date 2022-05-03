import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyProgram {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку содержащую ip");
        String str = scanner.nextLine();
        String ip = FindIp(str);
        System.out.println("Найден ip: " + ip + " и записан в файл Ip.txt");
        Write(ip);
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
    public static  void Write(String ip){
        try(FileWriter fw = new FileWriter("Ip.txt")){
            for(int i = 0; i < ip.length();i++) {
                fw.write(ip.charAt(i));
            }
            fw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
