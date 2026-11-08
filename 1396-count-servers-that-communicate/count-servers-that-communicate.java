class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int rowcnt[]=new int[n];
        int colcnt[]=new int[m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    rowcnt[i]++;
                    colcnt[j]++;
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && (rowcnt[i]>1 || colcnt[j]>1))
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}