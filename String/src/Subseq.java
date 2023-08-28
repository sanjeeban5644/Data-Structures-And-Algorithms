import java.util.ArrayList;
import java.util.List;

public class Subseq {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        String str = "abc";
        subseq("",str,ans);
        System.out.println(ans);
    }

    static void subseq(String p,String up,List<String> list){
        if(up.isEmpty()){
            list.add(p);
            return ;
        }

        char ch = up.charAt(0);
        subseq(p+ch,up.substring(1),list);
        subseq(p,up.substring(1),list);

    }

}
