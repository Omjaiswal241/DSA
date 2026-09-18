class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int profit=0;
        int j=0;
        for(int i=1;i<n-1;i++)
        {
            if(prices[i]<=prices[j])
            {
                j=i;
            }
            else if(prices[i]>prices[j] && prices[i]>prices[i+1])
            {
                profit+=prices[i]-prices[j];
                j=i;
            }
        }
        profit+=(prices[n-1]>prices[j])?(prices[n-1]-prices[j]):0;
        return profit;
    }
}