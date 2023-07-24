import java.util.Scanner;

public class ReverseDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String ans = func(n);
        System.out.println(Integer.parseInt(ans));
    }

    static String func(int n){
        if(n==0) return "";
        int t = n%10;
        String tt = Integer.toString(t);
        return tt+func(n/10);
    }


}
