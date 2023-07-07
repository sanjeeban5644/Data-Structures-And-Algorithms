import java.util.Scanner;

// find the no.of numbers which have even no.of digits

public class NoofDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {12,345,65,9999,20022};
        int ans = checkfunc(arr);
        System.out.println(ans);

        System.out.println("Test is : "+(int)Math.log10(7997));

    }
    static int checkfunc(int[] arr){
        int count = 0;
        for(int i : arr){
            if(checkdigit(i)){
                count++;
            }
        }
        return count;
    }
    static boolean checkdigit(int num){
        int t = (int)(Math.log10(num))+1;
        if(t%2==0) return true;
        return false;
    }
}
