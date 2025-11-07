class Solution {
    public int maxProfit(int[] prices) {
        int obp=-prices[0],osp=0,ocp=0;
        for(int i=1;i<prices.length;i++)
        {
            int nbp=Math.max(obp,ocp-prices[i]);
            int nsp=Math.max(osp,prices[i]+obp);
            int ncp=osp;
            obp=nbp;
            osp=nsp;
            ocp=ncp;
        }
        return osp;
    }
}