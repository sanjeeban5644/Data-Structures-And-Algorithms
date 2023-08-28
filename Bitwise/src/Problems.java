public class Problems {
    public static void main(String[] args) {
        int n = 56;
        System.out.println("Is even? : "+iseven(n));
        System.out.println("ith bit is: "+ithbit(n,4));
        System.out.println("After setting ith bit: "+setith(n,3));
        System.out.println("The 6th magic no. is: "+nthmagic(5));
        System.out.println("Is number power of 2?: "+checkPower(30));
    }

    static boolean checkPower(int num){
        int temp = num-1;
        if((num&temp)==0) return true;
        return false;
    }

    public static int nthmagic(int num){
        int ans = 0;
        int base = 5;
        while(num>0){
            int last = num&1;
            num=num>>1;
            ans+=(base*last);
            base*=5;
        }
        return ans;
    }

    public static boolean iseven(int n){
        return (n&1)==0;
    }

    public static int ithbit(int num,int pos){
        int a = 1<<(pos-1);
        int b = num&a;
        return b>>(pos-1);
    }
    public static int setith(int n,int pos){
        int a = 1<<(pos-1);
        int b = n|a;
        return b;
    }
}
