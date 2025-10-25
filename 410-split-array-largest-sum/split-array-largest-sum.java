class Solution {
    public int splitArray(int[] nums, int k) {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>low)
            {
                low=nums[i];
            }
            high+=nums[i];
        }
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(cansplit(nums,mid,k))
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
    public static boolean cansplit(int nums[],int mid,int k)
    {
        int sum=0,count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(sum+nums[i]>mid)
            {
                sum=0;
                count++;
            }
            sum+=nums[i];
        }
        count++;
        if(count<=k)
        {
            return true;
        }
        return false;
    }
}