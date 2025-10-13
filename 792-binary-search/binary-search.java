class Solution {
    public int search(int[] nums, int target) {
       int n=binary(nums,target,0,nums.length-1);
       return n;
    }
    public int binary(int ar[],int target,int low,int high)
    {
        while(low<=high)
        {
        int mid=low+(high-low)/2;
        if(ar[mid]==target)
        {
            return mid;
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
        return -1;
    }
}