class Solution {
    int maxgold=0;
    public int getMaximumGold(int[][] grid) {
        boolean [][]visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]!=0)
                {
                max(grid,i,j,0,visited);
                }
            }
        }
        return maxgold;
    }
    public void max(int grid[][],int r,int c,int asf,boolean [][]visited)
    {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || visited[r][c]==true || grid[r][c]==0)
        {
            maxgold=Math.max(maxgold,asf);
            return;
        }
        visited[r][c]=true;
        max(grid,r-1,c,asf+grid[r][c],visited);
        max(grid,r,c-1,asf+grid[r][c],visited);
        max(grid,r+1,c,asf+grid[r][c],visited);
        max(grid,r,c+1,asf+grid[r][c],visited);
        visited[r][c]=false;
    }
}