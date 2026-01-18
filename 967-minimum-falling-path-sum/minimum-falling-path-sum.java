class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int dp[][]=new int[n][n];
        for(int j=n-1;j>=0;j--)
        {
            dp[n-1][j]=matrix[n-1][j];
        }
        for(int i=n-2;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                int r=(j<n-1)?dp[i+1][j+1]:Integer.MAX_VALUE;
                int l=(j>0)?dp[i+1][j-1]:Integer.MAX_VALUE;
                int d=dp[i+1][j];
                dp[i][j]=matrix[i][j]+Math.min(Math.min(r,l),d);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<n;j++)
        {
            min=Math.min(min,dp[0][j]);
        }
        return min;
    }
}