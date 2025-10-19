class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length)
        {
            return -1;
        }
        int min=min(bloomDay);
        int max=max(bloomDay);
        int low=min;
        int high=max;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(possible(bloomDay,mid,m,k)==true)
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
    public static boolean possible(int ar[],int day,int m,int k)
    {
        int cut=0,bou=0;
        for(int i=0;i<ar.length;i++)
        {
            if(ar[i]<=day)
            {
                cut++;
            }
            else
            {
                bou+=(cut/k);
                cut=0;
            }
        }
        bou+=(cut/k);
        if(bou>=m)
        {
            return true;
        }
        return false;
    }
    public static int max(int ar[])
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<ar.length;i++)
        {
            if(max<ar[i])
            {
                max=ar[i];
            }
        }
        return max;
    }
    public static int min(int ar[])
    {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<ar.length;i++)
        {
            if(min>ar[i])
            {
                min=ar[i];
            }
        }
        return min;
    }
}