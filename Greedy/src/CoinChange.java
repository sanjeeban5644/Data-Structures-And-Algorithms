import java.util.*;

public class CoinChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] deno = {1,5,10,20,50,100,200,500};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : deno){
            map.put(i,0);
        }
        int index=deno.length-1;
        System.out.println("Enter the amount: ");
        int amt = in.nextInt();
        int temp= amt;
        while(temp>0){
            if(temp-deno[index]>=0){
                map.put(deno[index],map.getOrDefault(map.get(deno[index]),0)+1);
                temp-=deno[index];
            }else{
                index--;
            }
        }
        System.out.println("Amount is: "+amt);
        System.out.println("The Denominations needed are: ");
        List<Integer> list = new ArrayList<>(map.keySet());
        index=0;
        Collections.sort(list);
        for(int i : list){
            if(map.get(i)>0){
                System.out.println(i+" : "+map.get(i));
                index+=map.get(i);
            }
        }
        System.out.println("Total Denominations needed are: "+index);

    }
}
