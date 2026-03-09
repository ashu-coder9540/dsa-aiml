public class nthFibonacci {
     static int dp[];
      public static int fibo(int n) {
        if(n<=1) return n;
        if(dp[n]!=0) return dp[n]; //extra
        int ans = fibo(n-1) + fibo(n-2);
        dp[n] = ans; //extra
        return ans;
    }
    public static int nthFibo(int n) {
       dp = new int[n+1]; // idx from 0 to n
       return fibo(n);
    }
    public static void main(String[] args) {
        int fibo = nthFibo(4);
        System.out.print(fibo);
    }
}
