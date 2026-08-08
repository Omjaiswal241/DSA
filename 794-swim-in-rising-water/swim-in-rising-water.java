class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int low=0,high=(n*n)-1;
        int res=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(possible(grid,0,0,mid,new boolean[n][n]))
            {
                res=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return res;
    }
    public boolean possible(int grid[][],int i,int j,int t,boolean [][] visited)
    {
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || visited[i][j]==true || grid[i][j]>t)
        {
            return false;
        }
        if(i==grid.length-1 && j==grid[0].length-1)
        {
            return true;
        }
        visited[i][j]=true;
        boolean res=possible(grid,i-1,j,t,visited) || possible(grid,i,j-1,t,visited) || possible(grid,i+1,j,t,visited) ||possible(grid,i,j+1,t,visited);
        if(res)
        {
            return true;
        }
        return false;
    }
}