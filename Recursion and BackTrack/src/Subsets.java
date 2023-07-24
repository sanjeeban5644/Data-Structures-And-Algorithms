import java.util.Scanner;

public class Subsets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        subset("",str);
    }

    static void subset(String p,String up){
        if(up.equals("")){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subset(p+ch,up.substring(1));
        subset(p,up.substring(1));
    }

}
