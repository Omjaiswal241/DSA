class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=max(weights);
        int high=sum(weights);
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(check(weights,mid,days))
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
    public static boolean check(int ar[],int mid,int days)
    {
        int sum=0,count=0;
        for(int i=0;i<ar.length;i++)
        {
            if((sum+ar[i])>mid)
            {
                count++;
                sum=0;
            }
            sum+=ar[i];
        }
        count++;
        if(count<=days)
        {
            return true;
        }
        return false;
    }
    public static int sum(int [] ar)
    {
        int sum=0;
        for(int i=0;i<ar.length;i++)
        {
            sum+=ar[i];
        }
        return sum;
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
}