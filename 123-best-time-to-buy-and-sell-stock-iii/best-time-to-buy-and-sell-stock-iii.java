class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int sd[]=new int[n];
        sd[0]=0;
        int min_sellprice=prices[0];
        for(int i=1;i<n;i++)
        {
            sd[i]=(prices[i]-min_sellprice>0)?(prices[i]-min_sellprice):0;
            if(min_sellprice>prices[i])
            {
                min_sellprice=prices[i];
            }
        }
        int bd[]=new int[n];
        bd[n-1]=0;
        int max_buyprice=prices[n-1];
        for(int i=n-2;i>=0;i--)
        {
            bd[i]=(max_buyprice-prices[i]>0)?(max_buyprice-prices[i]):0;
            if(max_buyprice<prices[i])
            {
                max_buyprice=prices[i];
            }
        }
        for(int i=1;i<n;i++)
        {
            sd[i]=Math.max(sd[i],sd[i-1]);
            bd[n-i-1]=Math.max(bd[n-i-1],bd[n-i]);
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,sd[i]+bd[i]);
        }
        return ans;
    }
}