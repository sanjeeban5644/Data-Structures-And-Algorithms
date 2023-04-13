import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i]=in.nextInt();
        }
        List<List<Integer>> ans = new ArrayList<>();
        System.out.println("The Permutations are: ");
        permutation(ans,new ArrayList<>(),arr);
        System.out.println(ans);
    }
    static void permutation(List<List<Integer>> ans,List<Integer> temp,int[] arr){
        if(temp.size()==arr.length){
            ans.add(new ArrayList<>(temp));
        }
        for(int i = 0;i<arr.length;i++){
            if(temp.contains(arr[i])) continue;
            temp.add(arr[i]);
            permutation(ans,temp,arr);
            temp.remove(temp.size()-1);
        }
    }
}
