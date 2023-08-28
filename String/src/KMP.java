import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String str = "bacbabababacaca";
        String pattern = "ababaca";
        int substr_length = kmp(str,pattern);
        if(substr_length==-1){
            System.out.println("There is no matching substring");
        }else{
            System.out.println("There is matching substring at position : "+substr_length);
        }
    }

    static int kmp(String str,String pattern){  // O(m+n)
        int i = 0;
        int j = 0;
        int[] prefix_table = new int[pattern.length()];
        fillPrefixTable(prefix_table,pattern);
        while(i<str.length()){
            if(str.charAt(i)==pattern.charAt(j)){
                if(j==pattern.length()-1){
                    return i-j;
                }else{
                    i++;
                    j++;
                }
            }else if(j>0){
                j=prefix_table[j-1];
            }else{
                i++;
            }
        }
        return -1;
    }

    static void fillPrefixTable(int[] arr,String str){
         int i = 1;
         int j = 0;
         arr[0]=0;
         while(i<str.length()){
             if(str.charAt(i)==str.charAt(j)){
                 arr[i]=j+1;
                 i++;
                 j++;
             }else if(j>0){
                 j=arr[j-1];
             }else{
                 arr[i]=0;
                 i++;
             }
         }
    }

}
