import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the total no.of terms: ");
        int n = in.nextInt();
        System.out.println("Sum of Series is: "+fib(n));
        System.out.println("Sum of Series is: "+itrfib(n));
    }
    static int fib(int n){
        if(n<=1) return n;
        return fib(n-1)+fib(n-2);
    }

    static int itrfib(int n){
        int sum = 0;
        int a = 0;
        int b = 1;
        for(int i = 1;i<n;i++){
            sum = a+b;
            a=b;
            b=sum;
        }
        return sum;
    }
}
