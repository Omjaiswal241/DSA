class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i:nums)
        {
            sum+=i;
        }
        if(sum-target<0 || (sum-target)%2==1)
        {
            return 0;
        }
        int new_tar=(sum-target)/2;
        int n=nums.length;
        int dp[][]=new int[n][new_tar+1];
        for(int []i:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(nums,n-1,new_tar,dp);
    }
    public int helper(int nums[],int idx,int target,int [][]dp)
    {
        if(idx==0)
        {
            if(nums[idx]==0 && target==0)
            {
                return 2;
            }
            if(nums[idx]==target || target==0)
            {
                return 1;
            }
            return 0;
        }
        if(dp[idx][target]!=-1)
        {
            return dp[idx][target];
        }
        int notpick=helper(nums,idx-1,target,dp);
        int pick=0;
        if(nums[idx]<=target)
        {
            pick=helper(nums,idx-1,target-nums[idx],dp);
        }
        return dp[idx][target]=pick+notpick;
    }
}