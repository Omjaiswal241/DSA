class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,costs,0,dp);
    }
    public int solve(int n,int costs[],int idx,int dp[])
    {
        if(idx>=n)
        {
            return 0;
        }
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=idx+1;i<=Math.min(n,idx+3);i++)
        {
            ans=Math.min(ans,costs[i-1]+((i-idx)*(i-idx))+solve(n,costs,i,dp));
        }
        return dp[idx]=ans;
    }
}