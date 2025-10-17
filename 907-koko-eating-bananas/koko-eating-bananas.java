class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=max(piles);
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(total(piles,mid)==h)
            {
                high=mid-1;
            }
            else if(total(piles,mid)<h)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
    static int total(int ar[],int f)
    {
        int tot=0;
        for(int i=0;i<ar.length;i++)
        {
            tot+=Math.ceil((double)ar[i]/f);
        }
        return tot;
    }
    static int max(int ar[])
    {
        int max=0;
        for(int i=0;i<ar.length;i++)
        {
            max=Math.max(max,ar[i]);
        }
        return max;
    }
}