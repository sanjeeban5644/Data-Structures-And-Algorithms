import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InaccessibleObjectException;
import java.nio.Buffer;


public class FileDemo {
    public static void main(String[] args) {
//        try{
//            FileReader fr = new FileReader("name.txt");
//            int letters = fr.read();
//            while(fr.ready()){
//                System.out.println((char)letters);
//                letters = fr.read();
//            }
//            System.out.println();
//        }catch(IOException e){
//            System.out.println(e.getMessage());
//        }
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("You typed : "+br.readLine());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
