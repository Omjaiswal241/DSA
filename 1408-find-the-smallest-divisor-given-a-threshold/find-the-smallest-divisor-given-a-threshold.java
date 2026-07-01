class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l=1,h=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>h)
            {
                h=nums[i];
            }
        }
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(check(nums,mid,threshold))
            {
                h=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return l;
    }
    public boolean check(int nums[],int mid,int threshold)
    {
        int res=0;
        for(int i=0;i<nums.length;i++)
        {
            int a=nums[i]/mid;
            int b=nums[i]%mid>0?1:0;
            res+=(a+b);
        }
        if(res<=threshold)
        {
            return true;
        }
        return false;
    }
}