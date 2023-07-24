import java.util.Scanner;

public class SumofDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = func(n);
        System.out.println(ans);
    }

    static int func(int n){
        if(n==0) return 0;
        int t = n%10;
        return t+func(n/10);
    }


}
