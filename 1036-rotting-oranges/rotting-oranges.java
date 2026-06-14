class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int visited[][]=new int[n][m];
        for(int i[]:visited)
        {
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    grid[i][j]=1;
                    helper(grid,i,j,visited,0);
                    grid[i][j]=2;
                }
            }
        }
        int res=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                if(visited[i][j]==Integer.MAX_VALUE)
                {
                    return -1;
                }
                res=Math.max(res,visited[i][j]);
                }
            }
        }
        return res;
    }
    public void helper(int grid[][],int i,int j,int visited[][],int time)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1)
        {
            return ;
        }
        if(time>=visited[i][j])
        {
            return ;
        }
        grid[i][j]=2;
        visited[i][j]=Math.min(time,visited[i][j]);
        helper(grid,i-1,j,visited,time+1);
        helper(grid,i,j-1,visited,time+1);
        helper(grid,i+1,j,visited,time+1);
        helper(grid,i,j+1,visited,time+1);
        grid[i][j]=1;
    }
}