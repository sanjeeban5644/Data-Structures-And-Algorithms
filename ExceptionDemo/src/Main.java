import java.sql.SQLOutput;

public class Main {
    static void compute(int num) throws MyException{
        if(num>10){
            throw new MyException(num);
        }
        System.out.println("Normal exit");
    }
    public static void main(String[] args) {
        try{
            compute(5);
            compute(12);
        }catch (MyException e){
            System.out.println(e);
        }
    }
}
