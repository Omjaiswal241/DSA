class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        if(obstacleGrid[n-1][m-1]==1 || obstacleGrid[0][0]==1)
        {
            return 0;
        }
       int dp[][]=new int[n][m];
       dp[n-1][m-1]=1;
       for(int i=n-1;i>=0;i--)
       {
        for(int j=m-1;j>=0;j--)
        {
            if(obstacleGrid[i][j]==1)
            {
                dp[i][j]=0;
            }
            else
            {
                if(i+1<n)
                {
                    dp[i][j]+=dp[i+1][j];
                }
                if(j+1<m)
                {
                    dp[i][j]+=dp[i][j+1];
                }
            }
        }
       }
       return dp[0][0]; 
    }
}