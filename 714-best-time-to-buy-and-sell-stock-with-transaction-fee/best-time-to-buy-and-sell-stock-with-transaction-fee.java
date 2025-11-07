class Solution {
    public int maxProfit(int[] prices, int fee) {
        int obs=-prices[0];
        int oss=0;
        for(int i=1;i<prices.length;i++)
        {
            int nbs=Math.max(obs,oss-prices[i]);
            int nss=Math.max(oss,obs+prices[i]-fee);
            obs=nbs;
            oss=nss;
        }
        return oss;
    }
}