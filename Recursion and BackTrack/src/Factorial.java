import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Number: ");
        int n = in.nextInt();
        System.out.println("The Factorial of "+n+" is: "+fact(n));
    }
    static int fact(int n){
        if(n==1) return 1;
        return n*fact(n-1);
    }
}
