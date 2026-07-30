class Solution {
    int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> qu=new ArrayDeque<>();
        boolean visited[][]=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                qu.add(new int[]{i,j});
                visited[i][j]=true;
                }
            }
        }
        int timearr[][]=new int[m][n];
        for(int i[]:timearr)
        {
            Arrays.fill(i,-1);
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
                timearr[row][col]=time;
                for(int dir[]:directions)
                {
                    int newrow=dir[0]+row;
                    int newcol=dir[1]+col;
                    if(newrow<0 || newcol<0 || newrow>=m || newcol>=n || visited[newrow][newcol] || grid[newrow][newcol]==0)
                    {
                        continue;
                    }
                    qu.add(new int[]{newrow,newcol});
                    visited[newrow][newcol]=true;
                }
            }
            time++;
        }
        int ans=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    if(timearr[i][j]==-1)
                    {
                        return -1;
                    }
                    else
                    {
                        ans=Math.max(ans,timearr[i][j]);
                    }
                }
            }
        }
        return ans;
    }
}