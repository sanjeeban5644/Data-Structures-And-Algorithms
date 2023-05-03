import java.util.*;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "This is a nice Problem";
        String ans = "";
        Stack<Character> st = new Stack<>();
        int len = s.length();
        for(int i = len-1;i>=0;i--){
            if(s.charAt(i)==' '){
                while(!st.isEmpty()){
                    ans=ans+st.pop();
                }
                ans+=' ';
            }else{
                st.push(s.charAt(i));
            }
        }
        while(!st.isEmpty()){
            ans=ans+st.pop();
        }
        System.out.println(ans);
    }
}
