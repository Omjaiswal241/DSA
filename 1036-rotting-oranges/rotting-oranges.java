class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int visited[][]=new int[m][n];
        for(int i[]:visited)
        {
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    grid[i][j]=1;
                    dfs(grid,m,n,i,j,0,visited);
                    grid[i][j]=2;
                }
            }
        } 
        int ans=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    if(visited[i][j]==Integer.MAX_VALUE)
                    {
                        return -1;
                    }
                    else
                    {
                        ans=Math.max(visited[i][j],ans);
                    }
                }
            }
        }
        return ans;
    }
    public void dfs(int [][]grid,int m,int n,int i,int j,int time,int [][]visited)
    {
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]!=1)
        {
            return;
        }
        if(visited[i][j]!=Integer.MAX_VALUE && visited[i][j]<time)
        {
            return;
        }
        grid[i][j]=2;
        visited[i][j]=Math.min(visited[i][j],time);
        dfs(grid,m,n,i-1,j,time+1,visited);
        dfs(grid,m,n,i,j-1,time+1,visited);
        dfs(grid,m,n,i+1,j,time+1,visited);
        dfs(grid,m,n,i,j+1,time+1,visited);
        grid[i][j]=1;
    }
}