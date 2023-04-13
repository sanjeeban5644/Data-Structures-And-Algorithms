import java.util.Scanner;

public class printReverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Limit: ");
        int n = in.nextInt();
        print(n);
    }
    static void print(int n){
        if(n==0) return;
        else{
            System.out.print(" "+n);
            print(n-1);
        }
    }
}
