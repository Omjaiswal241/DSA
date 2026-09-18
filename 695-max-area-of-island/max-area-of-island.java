class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        int mark=2;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    int cnt=dfs(grid,i,j,mark);
                    if(ans<cnt)
                    {
                        ans=cnt;
                    }
                    mark++;
                }
            }
        }
        return ans;
    }
    public int dfs(int grid[][],int i,int j,int mark)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1)
        {
            return 0;
        }
        grid[i][j]=mark;
        return 1+dfs(grid,i-1,j,mark)+dfs(grid,i,j-1,mark)+dfs(grid,i+1,j,mark)+dfs(grid,i,j+1,mark);
    }
}