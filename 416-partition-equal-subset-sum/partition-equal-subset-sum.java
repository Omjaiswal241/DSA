class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i:nums)
        {
            sum+=i;
        }
        if(sum%2==1)
        {
            return false;
        }
        int tar=sum/2;
        int dp[][]=new int[n][sum+1];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(nums,0,0,tar,dp);
    }
    public boolean helper(int nums[],int idx,int sum,int tar,int dp[][])
    {
        if(sum==tar)
        {
            return true;
        }
        if(idx==nums.length)
        {
            return false;
        }
        if(dp[idx][sum]!=-1)
        {
            return dp[idx][sum]==1;
        }
        boolean take=false;
        if(sum+nums[idx]<=tar)
        {
            take=helper(nums,idx+1,sum+nums[idx],tar,dp);
        }
        boolean nottake=helper(nums,idx+1,sum,tar,dp);
        dp[idx][sum]=(take || nottake)?1:0;
        return take || nottake;
    }
}