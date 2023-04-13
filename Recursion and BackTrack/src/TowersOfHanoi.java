import java.util.Scanner;

public class TowersOfHanoi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the total no.of disks: ");
        int n = in.nextInt();
        toh(n,"Source","Destination","Auxiliary");
    }
    static void toh(int n,String source,String dest,String aux){
        if(n==1){
            System.out.println("Moving Disk "+n+" from "+source+" to "+dest);
            return;
        }
        toh(n-1,source,aux,dest);
        System.out.println("Moving Disk "+n+" from "+source+" to "+dest);
        toh(n-1,aux,dest,source);
    }
}
