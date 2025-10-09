class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return nums;
    }
    public static void mergesort(int ar[],int low,int high)
    {
        if(low>=high)
        {
            return;
        }
        int mid=low+(high-low)/2;
        mergesort(ar,low,mid);
        mergesort(ar,mid+1,high);
        merge(ar,low,mid,high);
    }
    public static void merge(int ar[],int low,int mid,int high)
    {
        int left=low;
        int right=mid+1;
        int res[]=new int[high-low+1];
        int k=0;
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
        for(int i=low;i<=high;i++)
        {
            ar[i]=res[i-low];
        }
    }
}