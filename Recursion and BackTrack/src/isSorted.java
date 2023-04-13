import java.util.Scanner;

public class isSorted {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println("Is the Array sorted?: "+issorted(arr,n));
    }

    static boolean issorted(int[] arr,int n){
        if(n==1) return true;
        return (arr[n-1]<arr[n-2])?false:issorted(arr,n-1);
    }

}
