class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int sd[]=new int[n];
        int bd[]=new int[n];
        int min=prices[0];
        for(int i=1;i<n;i++)
        {
            if(prices[i]<min)
            {
                min=prices[i];
            }
            else
            {
                sd[i]=prices[i]-min;
            }
        }
        int max1=prices[n-1];
        for(int i=n-2;i>=0;i--)
        {
            if(max1<prices[i])
            {
                max1=prices[i];
            }
            else
            {
                bd[i]=max1-prices[i];
            }
        }
        for(int i=1;i<n;i++)
        {
            sd[i]=Math.max(sd[i],sd[i-1]);
        }
        for(int i=n-2;i>=0;i--)
        {
            bd[i]=Math.max(bd[i],bd[i+1]);
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            sd[i]=sd[i]+bd[i];
            if(sd[i]>ans)
            {
                ans=sd[i];
            }
        }
        return ans;
    }
}