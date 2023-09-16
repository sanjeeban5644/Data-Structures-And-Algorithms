import java.util.*;
public class Fibonacci {

        public static void main(String[] args) {
            int n = 5;
            int fibo = fib(n);
            // Normal fibonacci
            for (int i = 0; i < n; i++) {
                System.out.print(fib(i) + " ");
            }
            // DP fibonacci
            System.out.println(fib_d(n));
            // Memoization
            int[] arr = new int[n+1];
            Arrays.fill(arr,-1);
            System.out.println(fib_m(arr,n));
        }

        static int fib(int n){
            if(n<=1) return n;
            return fib(n-1)+fib(n-2);
        }

        static int fib_d(int n){
            if(n<=1){
                return n;
            }

            int[] arr = new int[n+1];
            arr[0]=0;
            arr[1]=1;
            for(int i=2;i<=n;i++){
                arr[i]=arr[i-1]+arr[i-2];
            }
            return arr[n];
        }

        static int fib_m(int[] arr,int n){
            if(arr[n]!=-1){
                return arr[n];
            }
            if(n<=1){
                arr[n]=n;
                return n;
            }
            int sum = fib_m(arr,n-1)+fib_m(arr,n-2);
            arr[n]=sum;
            return sum;
        }
}
