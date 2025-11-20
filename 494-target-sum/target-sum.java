class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
        }
        if(sum-target<0 || (sum-target)%2==1)
        {
            return 0;
        }
        int newtar=(sum-target)/2;
        int dp[][]=new int[n][newtar+1];
        for(int []i:dp)
        {
            Arrays.fill(i,-1);
        }
        return diffsubset(nums,n-1,newtar,dp);
    }
    public static int diffsubset(int nums[],int idx,int tar,int [][]dp)
    {
        if(idx==0)
        {
            if(nums[idx]==0 && tar==0)
            {
                return 2;
            }
            if(tar==0 || nums[idx]==tar)
            {
                return 1;
            }
            return 0;
        }
        if(dp[idx][tar]!=-1)
        {
            return dp[idx][tar];
        }
        int nottake=diffsubset(nums,idx-1,tar,dp);
        int take=0;
        if(nums[idx]<=tar)
        {
            take=diffsubset(nums,idx-1,tar-nums[idx],dp);
        }
        return dp[idx][tar]=take+nottake;
    }
}