import java.util.Arrays;
import java.util.Scanner;

public class Practise {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {4,9,1,7,3,2,8,0};
        insertion(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void insertion(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            int flag = 0;
            for(int j = i+1;j>0;j--){
                if(arr[j-1]>arr[j]){
                    swap(arr,j-1,j);
                    flag=1;
                }
                if(flag==0) break;
            }
        }
    }






    static void selection(int[] arr){
        for(int i = 0;i<arr.length;i++){
            int lastindex = arr.length-i-1;
            int max = findmax(arr,0,lastindex);
            swap(arr,max,lastindex);
        }
    }


    static void swap(int[] arr,int max,int last){
        int temp = arr[max];
        arr[max]=arr[last];
        arr[last]=temp;
    }

    static int findmax(int[] arr, int start,int end){
        int ret = 0;
        for(int i = start;i<=end;i++){
            if(arr[i]>arr[ret]){
                ret=i;
            }
        }
        return ret;
    }




}
