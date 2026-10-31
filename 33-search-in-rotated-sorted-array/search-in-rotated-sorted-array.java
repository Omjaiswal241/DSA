class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int pivot_idx=pivot(nums);
        int ans=solve(nums,0,pivot_idx-1,target);
        if(ans!=-1)
        {
            return ans;
        }
        ans=solve(nums,pivot_idx,n-1,target);
        return ans;
    }
    public int pivot(int nums[])
    {
        int n=nums.length;
        int low=0,high=n-1;
        while(low<high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]<=nums[high])
            {
                high=mid;
            }
            else if(nums[low]<=nums[mid])
            {
                low=mid+1;
            }
        }
        return low;
    }
    public int solve(int nums[],int low,int high,int target)
    {
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[mid]<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1;
    }
}