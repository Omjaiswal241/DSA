class Solution {
    int MOD=1000000007;
    public int numberOfSets(int n, int k) {
        int dp[][]=new int[k+1][n+1];
        solve(n,k,dp);
        return dp[k][0];
    }
    public void solve(int n,int K,int dp[][])
    {
        for(int idx=0;idx<n;idx++)
        {
            dp[0][idx]=1;
        }
        for(int k=1;k<=K;k++)
        {
            int suff_sum[]=new int[n+1];
            for(int i=n-1;i>=0;i--)
            {
                suff_sum[i]=(suff_sum[i+1]+dp[k-1][i])%MOD;
            }
            for(int idx=n-1;idx>=0;idx--)
            {
                long skip=dp[k][idx+1]%MOD;
                long take=0;
                take=suff_sum[idx+1];
                dp[k][idx]=(int)(skip+take)%MOD;
            }
        }
    }
}