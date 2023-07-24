import java.util.Scanner;

public class nto1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        print(n);
    }

    static void print(int n){
        if(n==0) return;
        System.out.print(n+" ");
        print(n-1);
    }

}
