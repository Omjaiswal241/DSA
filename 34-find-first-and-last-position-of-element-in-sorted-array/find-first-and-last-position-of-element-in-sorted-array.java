class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
        {
            return new int[]{-1,-1};
        }
        int first=firstoccur(nums,target,0,nums.length-1);
        int last=lastoccur(nums,target,0,nums.length-1);
        return new int[]{first,last};
    }
    public int firstoccur(int ar[],int target,int low,int high)
    {
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(ar[mid]==target)
            {
                ans=mid;
                high=mid-1;
            }
            else if(ar[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
    public int lastoccur(int ar[],int target,int low,int high)
    {
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(ar[mid]==target)
            {
                ans=mid;
                low=mid+1;
            }
            else if(ar[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}