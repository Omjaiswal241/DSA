class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length)
        {
            return -1;
        }
        int l=1,h=Integer.MIN_VALUE;
        for(int i:bloomDay)
        {
            if(i>h)
            {
                h=i;
            }
        }
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(check(bloomDay,mid,k)>=m)
            {
                h=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return l;
    }
    public int check(int bloomDay[],int mid,int k)
    {
        int cut=0;
        int bou=0;
        int n=bloomDay.length;
        for(int i=0;i<n;i++)
        {
            if(bloomDay[i]<=mid)
            {
                cut++;
            }
            else
            {
                bou+=cut/k;
                cut=0;
            }
        }
        bou+=cut/k;
        return bou;
    }
}