class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int dp[][]=new int[n][n];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        int sum=0;
        for(int i:piles)
        {
            sum+=i;
        }
        int alice=solve(piles,0,n-1,dp);
        int bob=sum-alice;
        return alice-bob>0;
    }
    public int solve(int piles[],int i,int j,int dp[][])
    {
        if(i>j)
        {
            return 0;
        }
        if(i==j)
        {
            return piles[i];
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int take_i=piles[i]+Math.min(solve(piles,i+2,j,dp),solve(piles,i+1,j-1,dp));
        int take_j=piles[j]+Math.min(solve(piles,i,j-2,dp),solve(piles,i+1,j-1,dp));
        return dp[i][j]=Math.max(take_i,take_j);
    }
}