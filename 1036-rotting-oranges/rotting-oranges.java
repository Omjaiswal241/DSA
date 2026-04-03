class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int res[][]=new int[n][m];
        for(int i[]:res)
        {
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    grid[i][j]=1;
                    helper(grid,i,j,0,res);
                    grid[i][j]=2;
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    if(res[i][j]==Integer.MAX_VALUE)
                    {
                        return -1;
                    }
                    ans=Math.max(ans,res[i][j]);
                }
            }
        }
        return ans;
    }
    public void helper(int [][]grid,int i,int j,int time,int res[][])
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1)
        {
            return;
        }
        if(time>=res[i][j])
        {
            return;
        }
        int prev=grid[i][j];
        grid[i][j]=2;
        res[i][j]=Math.min(time,res[i][j]);
        helper(grid,i,j-1,time+1,res);
        helper(grid,i-1,j,time+1,res);
        helper(grid,i+1,j,time+1,res);
        helper(grid,i,j+1,time+1,res);
        grid[i][j]=prev;
    }
}