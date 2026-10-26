class Solution {
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]!=0)
                {
                    if(solve(grid,i,j)%k==0)
                    {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    public long solve(int grid[][],int i,int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0)
        {
            return 0;
        }
        long sum=grid[i][j];
        grid[i][j]=0;
        sum+=solve(grid,i-1,j);
        sum+=solve(grid,i,j-1);
        sum+=solve(grid,i+1,j);
        sum+=solve(grid,i,j+1);
        return sum;
    }
}