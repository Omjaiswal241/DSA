class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i:nums)
        {
            sum+=i;
        }
        int temp=sum-target;
        if(temp%2==1 || temp<0)
        {
            return 0;
        }
        int tar=temp/2;
        int dp[][]=new int[nums.length][tar+1];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(nums,nums.length-1,tar,dp);
    }
    public int helper(int nums[],int idx,int tar,int dp[][])
    {
        if(idx==0)
        {
            if(nums[idx]==0 && tar==0)
            {
                return 2;
            }
            if(nums[idx]==tar || tar==0)
            {
                return 1;
            }
            return 0;
        }
        if(dp[idx][tar]!=-1)
        {
            return dp[idx][tar];
        }
        int take=0;
        if(nums[idx]<=tar)
        {
            take=helper(nums,idx-1,tar-nums[idx],dp);
        }
        int nottake=helper(nums,idx-1,tar,dp);
        return dp[idx][tar]=take+nottake;
    }
}