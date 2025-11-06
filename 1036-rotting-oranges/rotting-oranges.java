class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int res[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(res[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<n*m;i++)
        {
            int row=i/m;
            int col=i%m;
            if(grid[row][col]==2)
            {
                grid[row][col]=1;
                helper(grid,row,col,0,res);
                grid[row][col]=2;
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
    public static void helper(int ar[][],int r,int c,int idx,int [][]res)
    {
        if(r<0 || c<0 || r>=ar.length || c>=ar[0].length || ar[r][c]==0)
        {
            return;
        }
        if(idx>=res[r][c])
        {
            return;
        }
        int prev=ar[r][c];
        ar[r][c]=2;
        res[r][c]=Math.min(res[r][c],idx);
        helper(ar,r-1,c,idx+1,res);
        helper(ar,r,c-1,idx+1,res);
        helper(ar,r+1,c,idx+1,res);
        helper(ar,r,c+1,idx+1,res);
        ar[r][c]=prev;
    }
}