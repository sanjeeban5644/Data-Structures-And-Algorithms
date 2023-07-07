public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,4,7,10,13,18,21,27,39,60};
        int ceil = ceil_func(arr,39);
        System.out.println(ceil);
        int floor = floor_func(arr,30);
        System.out.println(floor);
    }

    static int floor_func(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        // boundary condition
        if(target<arr[start]) return -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target<arr[mid]){
                end = mid-1;
            }else if(target>arr[mid]){
                start = mid+1;
            }else{
                return arr[mid];
            }
        }
        return arr[end];
    }

    static int ceil_func(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        // boundary condition
        if(target>arr[end]) return -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            //System.out.println(arr[mid]);
            if(target<arr[mid]){
                end = mid-1;
            }else if(target>arr[mid]){
                start = mid+1;
            }else{
                return arr[mid];
            }
        }
        return arr[start];
    }
}
