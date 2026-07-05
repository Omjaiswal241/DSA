class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        if(k>n)
        {
            return -1;
        }
        int l=Integer.MIN_VALUE,h=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>l)
            {
                l=nums[i];
            }
            h+=nums[i];
        }
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(check(nums,mid,k,n))
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
    public boolean check(int nums[],int mid,int k,int n)
    {
        int cnt=1;
        int curr=nums[0];
        for(int i=1;i<n;i++)
        {
            if(curr+nums[i]<=mid)
            {
                curr+=nums[i];
            }
            else
            {
                curr=0;
                cnt++;
                curr+=nums[i];
            }
        }
        if(cnt<=k)
        {
            return true;
        }
        return false;
    }
}