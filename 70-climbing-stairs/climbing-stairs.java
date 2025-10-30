class Solution {
    public int climbStairs(int n) {
       int res=climb(n,new int[n+1]);
       return res; 
    }
    public static int climb(int n,int dp[])
    {
        if(n==0)
        {
            return dp[n]=1;
        }
        if(dp[n]!=0)
        {
            return dp[n];
        }
        int ways=0;
        if(n-1>=0)
        {
            ways+=climb(n-1,dp);
        }
        if(n-2>=0)
        {
            ways+=climb(n-2,dp);
        }
        return dp[n]=ways;
    }
}