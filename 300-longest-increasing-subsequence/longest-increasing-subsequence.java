class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(nums,0,-1,dp);
    }
    public int helper(int nums[],int idx,int prev_idx,int [][]dp)
    {
        if(idx==nums.length)
        {
            return 0;
        }
        if(dp[idx][prev_idx+1]!=-1)
        {
            return dp[idx][prev_idx+1];
        }
        int len=helper(nums,idx+1,prev_idx,dp);
        if(prev_idx==-1 || nums[idx]>nums[prev_idx])
        {
            len=Math.max(len,1+helper(nums,idx+1,idx,dp));
        }
        return dp[idx][prev_idx+1]=len;
    }
}