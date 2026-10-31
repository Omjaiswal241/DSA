class Solution {
    int left=0;
    int up=1;
    int MOD=1000000007;
    int m,n;
    public int uniquePaths(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int dp[][][]=new int[m][n][2];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j][0]=-1;
                dp[i][j][1]=-1;
            }
        }
        return solve(grid,0,0,left,dp);
    }
    public int solve(int grid[][],int r,int c,int camefrom,int dp[][][])
    {
        if(r>=m || c>=n)
        {
            return 0;
        }
        if(r==m-1 && c==n-1)
        {
            return 1;
        }
        if(dp[r][c][camefrom]!=-1)
        {
            return dp[r][c][camefrom];
        }
        if(grid[r][c]==1)
        {
            if(camefrom==left)
            {
                return dp[r][c][camefrom]=solve(grid,r+1,c,up,dp);
            }
            else
            {
                return dp[r][c][camefrom]=solve(grid,r,c+1,left,dp);
            }
        }
        int total=0;
        total=(total+solve(grid,r+1,c,up,dp))%MOD;
        total=(total+solve(grid,r,c+1,left,dp))%MOD;
        return dp[r][c][camefrom]=total;
    }
}