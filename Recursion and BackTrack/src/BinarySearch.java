public class BinarySearch {
    public static void main(String[] args) {
         int[] arr = {1,3,5,7,9,11,12,15,18,20,23,29,30};
         int ans = search(arr,29,0,arr.length-1);
        System.out.println(ans);
    }

    static int search(int[] arr,int target,int start,int end){
        int mid = start + (end-start)/2;
        if(arr[mid]==target){
            return mid;
        }else if(target<arr[mid]){
            return search(arr,target,start,mid-1);
        }else{
            return search(arr,target,mid+1,end);
        }


    }

}
