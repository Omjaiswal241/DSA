class Solution {
    public int maxProfit(int[] prices) {
        int j=0,profit=0;
        for(int i=1;i<prices.length-1;i++)
        {
            if(prices[i]<prices[j])
            {
                j=i;
            }
            else if(prices[i]>prices[j] && prices[i]>prices[i+1])
            {
                profit+=prices[i]-prices[j];
                j=i;
            }
        }
        profit+=(prices[prices.length-1]-prices[j]>0)?prices[prices.length-1]-prices[j]:0;
        return profit;
    }
}