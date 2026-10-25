class Solution {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<m;i++)
        {
            if(grid[0][i]==0)
            {
                dfs(grid,0,i);
            }
            if(grid[n-1][i]==0)
            {
                dfs(grid,n-1,i);
            }
        }
        for(int i=1;i<n-1;i++)
        {
            if(grid[i][0]==0)
            {
                dfs(grid,i,0);
            }
            if(grid[i][m-1]==0)
            {
                dfs(grid,i,m-1);
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0)
                {
                    cnt++;
                    dfs(grid,i,j);
                }
            }
        }
        return cnt;
    }
    public void dfs(int grid[][],int i,int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==1)
        {
            return;
        }
        grid[i][j]=1;
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
    }
}