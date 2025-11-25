class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int j=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<prices[j])
            {
                j=i;
            }
            else
            {
                max=Math.max(max,prices[i]-prices[j]);
            }
        }
        return max; 
    }
}