import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoinChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] deno = {1,3,4,5};
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i : deno){
//            map.put(i,0);
//        }
        int index=deno.length-1;
        System.out.println("Enter the amount: ");
        int amt = in.nextInt();

        int[] dp = new int[amt+1];
        Arrays.fill(dp,amt+1);
        dp[0]=0;

        for(int i = 1;i<=amt;i++){
            for(int denos : deno){
                if(i-denos>=0){
                    dp[i]=Math.min(dp[i],1+dp[i-denos]);

                }
            }
        }
        if(dp[amt]<amt+1){
            System.out.println("The Total no.of denominations needed are: "+dp[amt]);
        }else{
            System.out.println("Cannot be achived");
        }

    }
}
