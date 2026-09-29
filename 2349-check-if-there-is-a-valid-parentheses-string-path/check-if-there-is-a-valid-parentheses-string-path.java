class Solution {
    Boolean dp[][][];
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        dp=new Boolean[m][n][m+n-1];
        return isvalid(grid,0,0,0);
    }
    public boolean isvalid(char[][] grid,int i,int j,int cnt)
    {
        if(i>=grid.length || j>=grid[0].length)
        {
            return false;
        }
        char x=grid[i][j];
        if(x=='(')
        {
            cnt++;
        }
        else
        {
            cnt--;
        }
        if(cnt<0)
        {
            return false;
        }
        if(i==grid.length-1 && j==grid[0].length-1)
        {
            return cnt==0;
        }
        if(dp[i][j][cnt]!=null)
        {
            return dp[i][j][cnt];
        }
        boolean right=isvalid(grid,i,j+1,cnt);
        boolean down=isvalid(grid,i+1,j,cnt);
        return dp[i][j][cnt]=(right || down);
    }
}