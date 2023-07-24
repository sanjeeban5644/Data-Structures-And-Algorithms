import java.util.Scanner;

public class CountZeroes {
    static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = func(n);
        System.out.println(ans);
    }

    static int func(int n){
        if(n==0) return count;
        int t = n%10;
        if(t==0) count++;
        return func(n/10);
    }

}
