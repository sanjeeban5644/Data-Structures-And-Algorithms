public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
        int ans = infi_search(arr,20);
        System.out.println("The element is at index: "+ans);
    }
    static int infi_search(int[] arr,int num){
        // we take the size in chunks. so at beginning the search size is 1;
        // we grow exponentially and then decrease exponentially. thus both take logn time;
        int start = 0;
        int end = 1;

        while(num>arr[end]){
            int newstart = end+1;
            int newend = start + (end-start+1)*2;
            end = newend;
            start = newstart;
        }

        int ans = binarysearch(arr,num,start,end);

        return ans;
    }

    static int binarysearch(int[] arr,int num,int start,int end){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(num>arr[mid]){
                start = mid+1;
            }else if(num<arr[mid]){
                end = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }


}
