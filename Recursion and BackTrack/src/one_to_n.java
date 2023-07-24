import java.util.Scanner;

public class one_to_n {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        print(n);
    }

    static void print(int n){
        if(n==0) return;
        print(n-1);
        System.out.print(n+" ");
    }

}
