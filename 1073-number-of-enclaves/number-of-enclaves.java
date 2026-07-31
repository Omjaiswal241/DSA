class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<n;i++)
        {
            if(grid[0][i]==1)
            {
                dfs(grid,0,i);
            }
            if(grid[m-1][i]==1)
            {
                dfs(grid,m-1,i);
            }
        }
        for(int i=1;i<m-1;i++)
        {
            if(grid[i][0]==1)
            {
                dfs(grid,i,0);
            }
            if(grid[i][n-1]==1)
            {
                dfs(grid,i,n-1);
            }
        }
        int res=0;
        for(int i=1;i<m-1;i++)
        {
            for(int j=1;j<n-1;j++)
            {
                res+=grid[i][j];
            }
        }
        return res;
    }
    public void dfs(int grid[][],int i,int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0)
        {
            return;
        }
        grid[i][j]=0;
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
    }
}