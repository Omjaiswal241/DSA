class Solution {
    int directions[][]={{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]==1)
        {
            return -1;
        }
        Queue<int[]> qu=new ArrayDeque<>();
        qu.add(new int[]{0,0});
        grid[0][0]=1;
        int level=1;
        while(qu.size()!=0)
        {
            int size=qu.size();
            for(int j=0;j<size;j++)
            {
            int curr[]=qu.poll();
            int row=curr[0];
            int col=curr[1];
            if(row==n-1 && col==m-1)
            {
                return level;
            }
            for(int dir[]:directions)
            {
                int newrow=row+dir[0];
                int newcol=col+dir[1];
                if(newrow<0 || newcol<0 || newrow>=n || newcol>=m || grid[newrow][newcol]==1)
                {
                    continue;
                }
                grid[newrow][newcol]=1;
                qu.add(new int[]{newrow,newcol});
            }
            }
            level++;
        }
        return -1;
    }
}