class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
        int sum=0;
        for(int i:stones)
        {
            sum+=i;
        }
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j]=true;
                }
                else if(i==0)
                {
                    dp[i][j]=false;
                }
                else
                {
                    boolean nottake=dp[i-1][j];
                    boolean take=(j-stones[i-1]>=0)?dp[i-1][j-stones[i-1]]:false;
                    dp[i][j]=take||nottake;
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<=sum/2;i++)
        {
            if(dp[n][i]==true)
            {
                int a=sum-i;
                ans=Math.min(ans,Math.abs(i-a));
            }
        }
        return ans;
    }
}