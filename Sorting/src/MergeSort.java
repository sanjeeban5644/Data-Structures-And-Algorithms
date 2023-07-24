import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6,2,9,1,4,3};
        mergeSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr,int lb, int ub){

        if(ub-lb==1) return;
            int mid = (lb+ub)/2;
            mergeSort(arr,lb,mid);
            mergeSort(arr,mid,ub);
            merge(arr,lb,mid,ub);

    }

    static void merge(int[] arr,int lb,int mid,int ub){
        int i = lb;
        int k = 0;
        int j = mid;
        int[] temp = new int[ub-lb];
        while(i<mid && j<ub){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<mid){
            temp[k]=arr[i];
            i++;k++;
        }
        while(j<ub){
            temp[k]=arr[j];
            j++;k++;
        }
        for(k=0;k<temp.length;k++){
            arr[k+lb]=temp[k];
        }
    }




}
