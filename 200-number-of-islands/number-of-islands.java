class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int cnt=0;
        boolean visited[][]=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                char x=grid[i][j];
                if(x=='1' && visited[i][j]==false)
                {
                    cnt++;
                    dfs(grid,i,j,visited);
                }
            }
        }
        return cnt;
    }
    public void dfs(char grid[][],int i,int j,boolean [][]visited)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] || grid[i][j]=='0')
        {
            return ;
        }
        visited[i][j]=true;
        dfs(grid,i-1,j,visited);
        dfs(grid,i,j-1,visited);
        dfs(grid,i+1,j,visited);
        dfs(grid,i,j+1,visited);
    }
}