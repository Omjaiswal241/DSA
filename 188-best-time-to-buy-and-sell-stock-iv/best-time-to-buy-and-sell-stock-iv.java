class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
       int dp[][][]=new int[n][2][k+1];
       for(int [][]layer:dp)
       {
        for(int []row:layer)
        {
            Arrays.fill(row,-1);
        }
       }
       return maxprofit(prices,0,1,k,dp); 
    }
    public static int maxprofit(int []prices,int idx,int buy,int cap,int [][][]dp)
    {
        if(idx==prices.length || cap==0)
        {
            return 0;
        }
        if(dp[idx][buy][cap]!=-1)
        {
            return dp[idx][buy][cap];
        }
        int profit=0;
        if(buy==1)
        {
            profit=Math.max(-prices[idx]+maxprofit(prices,idx+1,0,cap,dp),maxprofit(prices,idx+1,1,cap,dp));
        }
        else
        {
            profit=Math.max(prices[idx]+maxprofit(prices,idx+1,1,cap-1,dp),maxprofit(prices,idx+1,0,cap,dp));
        }
        return dp[idx][buy][cap]=profit;
    }
}