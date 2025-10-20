class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=max(nums);
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(possible(nums,mid,threshold)==true)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean possible(int ar[],int day,int threshold)
    {
        int sum=0;
        for(int i=0;i<ar.length;i++)
        {
            sum+=Math.ceil((double)ar[i]/day);
        }
        if(sum<=threshold)
        {
            return true;
        }
        return false;
    }
    public static int max(int nums[])
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
            }
        }
        return max;
    }
}