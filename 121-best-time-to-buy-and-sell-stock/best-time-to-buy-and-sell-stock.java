class Solution {
    public int maxProfit(int[] prices) {
        int i=0,j=1;
        int maxsum=0;
        while(j<prices.length)
        {
            if((prices[j]-prices[i])<0)
            {
                i=j;
                j++;
            }
            else{
                maxsum=Math.max(maxsum,(prices[j]-prices[i]));
                j++;
            }
        }
        return maxsum;
    }
}