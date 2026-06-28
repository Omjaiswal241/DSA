class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
        {
            return new int[]{-1,-1};
        }
        int a=first(nums,target);
        int b=last(nums,target);
        return new int[]{a,b};
    }
    public int first(int nums[],int target)
    {
        int ans=-1;
        int n=nums.length;
        int l=0,h=n-1;
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(nums[m]==target)
            {
                ans=m;
                h=m-1;
            }
            else if(nums[m]>target)
            {
                h=m-1;
            }
            else
            {
                l=m+1;
            }
        }
        return ans;
    }
    public int last(int nums[],int target)
    {
        int ans=-1;
        int n=nums.length;
        int l=0,h=n-1;
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(nums[m]==target)
            {
                ans=m;
                l=m+1;
            }
            else if(nums[m]<target)
            {
                l=m+1;
            }
            else
            {
                h=m-1;
            }
        }
        return ans;
    }
}