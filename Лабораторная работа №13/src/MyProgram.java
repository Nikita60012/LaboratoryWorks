import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyProgram {
    public static void main(String[] args){
        ReadCode();
    }
    public static void ReadCode(){
        StringBuffer text = new StringBuffer();
        try(FileReader rd = new FileReader("Comments.txt")) {
            int textChar;
            while((textChar = rd.read()) != -1){
                text.append((char)textChar);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Code(text);
    }
    public static void Code(StringBuffer code){

        String clearCode = code.toString();
        clearCode = clearCode.replaceAll("\\//.+","");
        clearCode = clearCode.replaceAll("/\\*(?s).*?\\*/","");
        try(FileWriter wr = new FileWriter("Clear Code.txt")){
            wr.write(clearCode);
            wr.flush();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
