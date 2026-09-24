class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int obd=-prices[0];
        int osd=0;
        int cd=0;
        for(int i=1;i<n;i++)
        {
            int nbd=Math.max(obd,cd-prices[i]);
            int nsd=Math.max(osd,prices[i]+obd);
            cd=osd;
            obd=nbd;
            osd=nsd;
        }
        return osd;
    }
}