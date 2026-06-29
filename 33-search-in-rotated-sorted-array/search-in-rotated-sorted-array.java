class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int pivot_idx=pivot(nums,n);
        int idx;
        idx=binarysearch(nums,target,0,pivot_idx-1);
        if(idx!=-1)
        {
            return idx; 
        }
        idx=binarysearch(nums,target,pivot_idx,n-1);
        return idx;
    }
    public int pivot(int nums[],int n)
    {
        int l=0,h=n-1;
        while(l<h)
        {
            int mid=l+(h-l)/2;
            if(nums[mid]>nums[h])
            {
                l=mid+1;
            }
            else
            {
                h=mid;
            }
        }
        return l;
    }
    public int binarysearch(int nums[],int target,int l,int h)
    {
        int ans=-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(nums[mid]==target)
            {
                ans=mid;
                break;
            }
            else if(nums[mid]>target)
            {
                h=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return ans;
    }
}