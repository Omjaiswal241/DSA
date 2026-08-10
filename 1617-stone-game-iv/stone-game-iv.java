class Solution {
    public boolean winnerSquareGame(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    public boolean solve(int n,int dp[])
    {
        if(n==0)
        {
            return false;
        }
        if(dp[n]!=-1)
        {
            return dp[n]==1?true:false;
        }
        int lim=(int)Math.sqrt(n);
        for(int i=1;i<=lim;i++)
        {
            if(solve(n-(int)Math.pow(i,2),dp)==false)
            {
                dp[n]=1;
                return true;
            }
        }
        dp[n]=0;
        return false;
    }
}