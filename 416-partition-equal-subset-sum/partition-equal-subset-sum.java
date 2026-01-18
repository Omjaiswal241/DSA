class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
        }
        if(sum%2==1)
        {
            return false;
        }
        int target=sum/2;
        int dp[][]=new int[n][target+1];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(nums,n-1,target,dp);
    }
    public boolean helper(int nums[],int idx,int target,int [][]dp)
    {
        if(target==0)
        {
            return true;
        }
        if(idx==0)
        {
            return nums[0]==target;
        }
        if(dp[idx][target]!=-1)
        {
            return dp[idx][target]==1;
        }
        boolean nottake=helper(nums,idx-1,target,dp);
        boolean take=false;
        if(nums[idx]<=target)
        {
            take=helper(nums,idx-1,target-nums[idx],dp);
        }
        dp[idx][target]=(take||nottake)?1:0;
        return take||nottake;
    }
}