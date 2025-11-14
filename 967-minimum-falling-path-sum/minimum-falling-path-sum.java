class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int dp[]=new int[n];
        for(int i=0;i<n;i++)
        {
            dp[i]=matrix[n-1][i];
        } 
        int curr[]=new int[n];
        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                if(j==0)
                {
                    curr[0]=matrix[i][j]+Math.min(dp[0],dp[1]);
                }
                else if(j==n-1)
                {
                    curr[n-1]=matrix[i][j]+Math.min(dp[n-2],dp[n-1]);
                }
                else
                {
                    curr[j]=matrix[i][j]+Math.min(Math.min(dp[j-1],dp[j]),dp[j+1]);
                }
            }
            for(int k=0;k<n;k++)
            {
                dp[k]=curr[k];
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(dp[i]<min)
            {
                min=dp[i];
            }
        }
        return min;
    }
}