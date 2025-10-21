class Solution {
    public boolean checkValidGrid(int[][] grid) {
        return isknight(grid,0,0,0);
    }
    public static boolean isknight(int [][] grid,int r,int c,int count)
    {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]!=count)
        {
            return false;
        }
        if(count==(grid.length*grid[0].length)-1)
        {
            return true;
        }
            boolean ans1=isknight(grid,r-2,c+1,count+1);
            boolean ans2=isknight(grid,r-1,c+2,count+1);
            boolean ans3=isknight(grid,r+1,c+2,count+1);
            boolean ans4=isknight(grid,r+2,c+1,count+1);
            boolean ans5=isknight(grid,r+2,c-1,count+1);
            boolean ans6=isknight(grid,r+1,c-2,count+1);
            boolean ans7=isknight(grid,r-1,c-2,count+1);
            boolean ans8=isknight(grid,r-2,c-1,count+1);
            return ans1||ans2||ans3||ans4||ans5||ans6||ans7||ans8;
    }
}