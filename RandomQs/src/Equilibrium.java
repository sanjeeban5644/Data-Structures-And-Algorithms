public class Equilibrium {
    public static void main(String[] args) {
        int[] arr = {1,2 ,6,2,1,4,0,-1};
        int ans = -1;
        for(int i = 0;i<arr.length;i++){
            int left = findLeftSum(arr,i);
            int right = findRightSum(arr,i);
            //System.out.println("Left: "+left+"  Right: "+right);
            if(left==right){
                ans = i;
                break;
            }
        }

        if(ans==-1){
            System.out.println("There is no equlibrium");
        }else{
            System.out.println("Equilibrium index is : "+ans);
        }

    }


    static int findLeftSum(int[] arr,int i){
        int sum = 0;
        for(int j = 0;j<i;j++){
            sum+=arr[j];
        }
        return sum;
    }

    static int findRightSum(int[] arr,int i){
        int sum = 0;
        for(int j =i+1;j<arr.length;j++){
            sum+=arr[j];
        }
        return sum;
    }



}
