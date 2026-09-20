class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n][2][k+1];
        for(int layers[][]:dp)
        {
            for(int i[]:layers)
            {
                Arrays.fill(i,-1);
            }
        }
        return helper(prices,0,1,k,dp);
    }
    public int helper(int prices[],int idx,int buy,int k,int dp[][][])
    {
        if(idx==prices.length || k==0)
        {
            return 0;
        }
        if(dp[idx][buy][k]!=-1)
        {
            return dp[idx][buy][k];
        }
        int profit=0;
        if(buy==1)
        {
            profit=Math.max((-prices[idx]+helper(prices,idx+1,0,k,dp)),helper(prices,idx+1,1,k,dp));
        }
        else
        {
            profit=Math.max((prices[idx]+helper(prices,idx+1,1,k-1,dp)),helper(prices,idx+1,0,k,dp));
        }
        return dp[idx][buy][k]=profit;
    }
}