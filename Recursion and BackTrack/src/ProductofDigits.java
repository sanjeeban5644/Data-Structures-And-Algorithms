import java.util.Scanner;

public class ProductofDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = product(n);
        System.out.println(ans);
    }

    static int product(int n){
        if(n<=1) return 1;
        int t = n%10;
        return t*product(n/10);
    }

}
