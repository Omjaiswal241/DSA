class Solution {
    int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> qu=new ArrayDeque<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                qu.add(new int[]{i,j});
                }
            }
        }
        int time=0;
        while(qu.size()>0)
        {
            int size=qu.size();
            while(size-- >0)
            {
                int curr[]=qu.poll();
                int row=curr[0];
                int col=curr[1];
                for(int dir[]:directions)
                {
                    int newrow=dir[0]+row;
                    int newcol=dir[1]+col;
                    if(newrow<0 || newcol<0 || newrow>=m || newcol>=n || grid[newrow][newcol]!=1)
                    {
                        continue;
                    }
                    qu.add(new int[]{newrow,newcol});
                    grid[newrow][newcol]=2;
                }
            }
            time++;
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    return -1;
                }
            }
        }
        return time>0?time-1:0;
    }
}