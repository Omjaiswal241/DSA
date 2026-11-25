class Solution {
    class Pair
    {
        int r,c,rem;
        Pair(int r,int c,int rem)
        {
            this.r=r;
            this.c=c;
            this.rem=rem;
        }
    }
    int direction[][]={{-1,0},{0,-1},{1,0},{0,1}};
    public int shortestPath(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][][]=new boolean[n][m][k+1];
        Queue<Pair> qu=new ArrayDeque<>();
        qu.add(new Pair(0,0,k));
        visited[0][0][k]=true;
        int steps=0;
        while(qu.size()!=0)
        {
            int size=qu.size();
            while(size-->0)
            {
                Pair curr=qu.poll();
                int row=curr.r;
                int col=curr.c;
                if(row==n-1 && col==m-1)
                {
                    return steps;
                }
                for(int dir[]:direction)
                {
                    int nr=row+dir[0];
                    int nc=col+dir[1];
                    if(nr<0 || nc<0 || nr>=n || nc>=m)
                    {
                        continue;
                    }
                    int nrem=curr.rem-grid[nr][nc];
                    if(nrem>=0 && visited[nr][nc][nrem]==false)
                    {
                        qu.add(new Pair(nr,nc,nrem));
                        visited[nr][nc][nrem]=true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}