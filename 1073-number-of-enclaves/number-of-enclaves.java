class Solution {
    int M;
    int N;
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        M=m;
        N=n;
        int temp[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            temp[i]=grid[i].clone();
        }
        boolean [][]visited=new boolean[m][n];
        for(int i=0;i<n;i++)
        {
            if(grid[0][i]==1)
            {
                dfs(grid,0,i,temp,visited);
            }
            if(grid[m-1][i]==1)
            {
                dfs(grid,m-1,i,temp,visited);
            }
        }
        for(int i=1;i<m-1;i++)
        {
            if(grid[i][0]==1)
            {
                dfs(grid,i,0,temp,visited);
            }
            if(grid[i][n-1]==1)
            {
                dfs(grid,i,n-1,temp,visited);
            }
        }
        int res=0;
        for(int i=1;i<m-1;i++)
        {
            for(int j=1;j<n-1;j++)
            {
                res+=temp[i][j];
            }
        }
        return res;
    }
    public void dfs(int grid[][],int i,int j,int[][] temp,boolean [][]visited)
    {
        if(i<0 || j<0 || i>=M || j>=N || visited[i][j] || grid[i][j]==0)
        {
            return;
        }
        temp[i][j]=0;
        visited[i][j]=true;
        dfs(grid,i-1,j,temp,visited);
        dfs(grid,i,j-1,temp,visited);
        dfs(grid,i+1,j,temp,visited);
        dfs(grid,i,j+1,temp,visited);
    }
}