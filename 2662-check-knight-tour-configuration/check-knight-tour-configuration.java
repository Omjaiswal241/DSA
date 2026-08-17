class Solution {
    int directions[][]={{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0)
        {
            return false;
        }
        return helper(0,0,grid,0);
    }
    public boolean helper(int r,int c,int grid[][],int cnt)
    {
        if(cnt==(grid.length*grid[0].length)-1)
        {
            return true;
        }
        for(int dir[]:directions)
        {
            int nrow=r+dir[0];
            int ncol=c+dir[1];
            if(nrow<0 || ncol<0 || nrow>=grid.length || ncol>=grid[0].length || grid[nrow][ncol]!=cnt+1)
            {
                continue;
            }
            boolean res=helper(nrow,ncol,grid,cnt+1);
            if(res)
            {
                return true;
            }
        }
        return false;
    }
}