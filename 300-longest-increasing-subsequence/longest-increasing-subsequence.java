class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int [n][n+1];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(nums,0,-1,dp);
    }
    public static int helper(int nums[],int idx,int prev,int dp[][])
    {
        if(idx==nums.length)
        {
            return 0;
        }
        if(dp[idx][prev+1]!=-1)
        {
            return dp[idx][prev+1];
        }
        int len=helper(nums,idx+1,prev,dp);
        if(prev==-1 || nums[idx]>nums[prev])
        {
            len=Math.max(len,1+helper(nums,idx+1,idx,dp));
        }
        return dp[idx][prev+1]=len;
    }
}