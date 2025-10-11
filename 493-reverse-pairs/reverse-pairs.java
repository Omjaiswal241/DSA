class Solution {
    public int reversePairs(int[] nums) {
        int count;
        int low=0;
        int high=nums.length-1;
        count=mergesort(nums,low,high);
        return count;
    }
    public static int mergesort(int ar[],int low,int high)
    {
        int count=0;
        if(low>=high)
        {
            return 0;
        }
        int mid=low+(high-low)/2;
        count+=mergesort(ar,low,mid);
        count+=mergesort(ar,mid+1,high);
        count+=merge(ar,low,mid,high);
        return count;
    }
    public static int merge(int ar[],int low,int mid,int high)
    {
        int left=low;
        int right=mid+1;
        int res[]=new int[high-low+1];
        int k=0;
        int count=0;
        int j=mid+1;
        for(int i=low;i<=mid;i++)
        {
            while(j<=high && ar[i]>2L*ar[j])
            {
                j++;
            }
            count+=(j-(mid+1));
        }
        while(left<=mid && right<=high)
        {
            if(ar[left]<=ar[right])
            {
                res[k++]=ar[left++];
            }
            else
            {
                res[k++]=ar[right++];
            }
        }
        while(left<=mid)
        {
            res[k++]=ar[left++];
        }
        while(right<=high)
        {
            res[k++]=ar[right++];
        }
        for(int i=0;i<res.length;i++)
        {
            ar[low+i]=res[i];
        }
        return count;
    }
}