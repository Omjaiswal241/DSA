class Solution {
    public int climbStairs(int n) {
        int res=helper(n,new int[n+1]);
        return res;
    }
    public int helper(int n,int dp[])
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
        if(n>=1)
        {
            ways+=helper(n-1,dp);
        }
        if(n>=2)
        {
            ways+=helper(n-2,dp);
        }
        return dp[n]=ways;
    }
}