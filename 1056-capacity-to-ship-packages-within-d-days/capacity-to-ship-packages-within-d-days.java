class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0,h=0;
        for(int i=0;i<weights.length;i++)
        {
            if(weights[i]>l)
            {
                l=weights[i];
            }
            h+=weights[i];
        }
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(check(weights,mid)<=days)
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
    public int check(int ar[],int mid)
    {
        int cnt=0;
        int sum=0;
        for(int i=0;i<ar.length;i++)
        {
            if(sum+ar[i]<=mid)
            {
                sum+=ar[i];
            }
            else
            {
                cnt++;
                sum=ar[i];
            }
        }
        cnt+=(sum>0)?1:0;
        return cnt;
    }
}