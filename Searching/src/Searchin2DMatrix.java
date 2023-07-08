public class Searchin2DMatrix {
    public static void main(String[] args) {
        int[][] mat = {{10,20,30,40},{15,25,35,45},{28,29,37,49},{33,34,38,50}};
//        System.out.println("row length: "+mat.length);
//        System.out.println("col length: "+mat[0].length);
        int ans = searchmatrix(mat,37);
        System.out.println(ans);
    }

    static int searchmatrix(int[][] mat, int target){
        int start = 0;
        int end = mat[0].length-1;
        while(start<mat.length && end>=0){
            //System.out.println("start: "+start+" end: "+end+" "+mat[start][end]);
            if(mat[start][end]==target){
                return mat[start][end];
            }else if(mat[start][end]>target){
                end--;
            }else{
                start++;
            }

        }
        return -1;
    }
}
