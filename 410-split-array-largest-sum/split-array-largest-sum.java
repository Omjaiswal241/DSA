class Solution {
    public int splitArray(int[] nums, int k) {
        int low=Integer.MIN_VALUE;
        int high=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>low)
            {
                low=nums[i];
            }
            high+=nums[i];
        }
        while(low<=high)
        {
            int mid=(low+(high-low)/2);
            if(helper(nums,mid,k))
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
    public boolean helper(int nums[],int mid,int k)
    {
        int cnt=1;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            if(sum+nums[i]>mid)
            {
                sum=0;
                cnt++;
            }
            sum+=nums[i];
        }
        if(cnt<=k)
        {
            return true;
        }
        return false;
    }
}