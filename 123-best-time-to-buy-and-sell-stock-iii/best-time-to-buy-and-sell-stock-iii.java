class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int sd[]=new int[n];
        int bd[]=new int[n];
        int sd_min=prices[0];
        sd[0]=0;
        for(int i=1;i<prices.length;i++)
        {
            sd[i]=prices[i]-sd_min>0?prices[i]-sd_min:0;
            if(prices[i]-sd_min<0)
            {
                sd_min=prices[i];
            }
        }
        bd[n-1]=0;
        int bd_max=prices[n-1];
        for(int i=n-2;i>=0;i--)
        {
            if(bd_max-prices[i]<=0)
            {
                bd_max=prices[i];
                bd[i]=0;
            }
            else
            {
                bd[i]=bd_max-prices[i];
            }
        }
        for(int i=1;i<n;i++)
        {
            if(sd[i]<sd[i-1])
            {
                sd[i]=sd[i-1];
            }
        }
        for(int i=n-2;i>=0;i--)
        {
            if(bd[i]<bd[i+1])
            {
                bd[i]=bd[i+1];
            }
        }
        int max_profit=0;
        for(int i=0;i<n;i++)
        {
            int sum=sd[i]+bd[i];
            max_profit=Math.max(max_profit,sum);
        }
        return max_profit;
    }
}