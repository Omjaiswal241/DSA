class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    islandhelper(grid,i,j);
                }
            }
        }
        return count;
    }
    public static void islandhelper(char [][]grid,int row,int col)
    {
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]!='1')
        {
            return;
        }
        grid[row][col]='2';
        islandhelper(grid,row-1,col);
        islandhelper(grid,row,col+1);
        islandhelper(grid,row+1,col);
        islandhelper(grid,row,col-1);
    }
}