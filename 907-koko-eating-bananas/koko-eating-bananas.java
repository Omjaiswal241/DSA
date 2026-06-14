class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=1,e=piles[0];
        for(int i=1;i<piles.length;i++)
        {
            if(piles[i]>e)
            {
                e=piles[i];
            }
        }
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            int f=helper(piles,mid);
            if(f>h)
            {
                s=mid+1;
            }
            else if(f<=h)
            {
                e=mid-1;
            }
        }
        return s;
    }
    public int helper(int [] piles,int mid)
    {
        int res=0;
        for(int i=0;i<piles.length;i++)
        {
            res+=Math.ceil((double)piles[i]/mid);   
        }
        return  res;
    }
}