import java.util.Scanner;

public class IsPalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        boolean ans = ispalin(str,0,str.length()-1);
        System.out.println(ans);
    }

    static boolean ispalin(String str,int l,int r){
        if(l>=r){
            return true;
        }
        if(str.charAt(l)!=str.charAt(r)){
            return false;
        }
        return ispalin(str,l+1,r-1);
    }

}
