class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        int sum=0;
        for(int i:nums)
        {
            sum+=i;
        }
        int player1=solve(nums,0,n-1,dp);
        int player2=sum-player1;
        return (player1-player2)>=0;
    }
    public int solve(int nums[],int i,int j,int dp[][])
    {
        if(i>j)
        {
            return 0;
        }
        if(i==j)
        {
            return nums[i];
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int take_i=nums[i]+Math.min(solve(nums,i+2,j,dp),solve(nums,i+1,j-1,dp));
        int take_j=nums[j]+Math.min(solve(nums,i,j-2,dp),solve(nums,i+1,j-1,dp));
        return dp[i][j]=Math.max(take_i,take_j);
    }
}