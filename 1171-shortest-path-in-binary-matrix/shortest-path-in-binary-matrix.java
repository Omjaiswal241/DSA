class Solution {
    int directions[][]={{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
    class Pair implements Comparable<Pair>
    {
        int dist;
        int ar[];
        Pair(int dist,int ar[])
        {
            this.dist=dist;
            this.ar=ar;
        }
        public int compareTo(Pair o)
        {
            return Integer.compare(this.dist,o.dist);
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int res[][]=new int[n][n];
        for(int i[]:res)
        {
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        if(grid[0][0]==1)
        {
            return -1;
        }
        res[0][0]=1;
        pq.add(new Pair(1,new int[]{0,0}));
        while(pq.size()!=0)
        {
            Pair curr=pq.poll();
            int row=curr.ar[0];
            int col=curr.ar[1];
            if(curr.dist>res[row][col])
            {
                continue;
            }
            for(int dist[]:directions)
            {
                int nr=row+dist[0];
                int nc=col+dist[1];
                if(nr<0 || nc<0 || nr>=n || nc>=n || grid[nr][nc]==1)
                {
                    continue;
                }
                if(res[nr][nc]>res[row][col]+1)
                {
                    res[nr][nc]=res[row][col]+1;
                    pq.add(new Pair(res[nr][nc],new int[]{nr,nc}));
                }
            }
        }
        return res[n-1][n-1]==Integer.MAX_VALUE?-1:res[n-1][n-1];
    }
}