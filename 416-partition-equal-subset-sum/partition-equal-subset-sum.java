class Solution {
    public boolean canPartition(int[] nums) {
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
        int dp[][]=new int[nums.length][tar+1];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(nums,nums.length-1,tar,dp);
    }
    public boolean helper(int nums[],int idx,int tar,int [][]dp)
    {
        if(tar==0)
        {
            return true;
        }
        if(idx==0)
        {
            return nums[idx]==tar;
        }
        if(dp[idx][tar]!=-1)
        {
            return dp[idx][tar]==1;
        }
        boolean take=false;
        if(nums[idx]<=tar)
        {
            take=helper(nums,idx-1,tar-nums[idx],dp);
        }
        boolean nottake=helper(nums,idx-1,tar,dp);
        dp[idx][tar]=(take || nottake)?1:0;
        return take || nottake;
    } 
}