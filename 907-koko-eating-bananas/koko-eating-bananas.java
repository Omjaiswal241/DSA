class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1,e=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++)
        {
            if(piles[i]>e)
            {
                e=piles[i];
            }
        }
        while(l<=e)
        {
            int mid=l+(e-l)/2;
            if(helper(piles,h,mid))
            {
                e=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return l;
    }
    public boolean helper(int piles[],int h,int mid)
    {
        int cnt=0;
        for(int i=0;i<piles.length;i++)
        {
            cnt+=Math.ceil((double)piles[i]/mid);
        }
        if(cnt<=h)
        {
            return true;
        }
        return false;
    }
}