class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    public int solve(int n,int dp[])
    {
        if(n==0)
        {
            return 1;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        int ways=0;
        if(n>=2)
        {
            ways+=solve(n-2,dp);
        }
        if(n>=1)
        {
            ways+=solve(n-1,dp);
        }
        return dp[n]=ways;
    }
}