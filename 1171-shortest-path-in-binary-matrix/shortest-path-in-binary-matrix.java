class Solution {
    int directions[][]={{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
    class Pair implements Comparable<Pair>
    {
        int dist;
        int []ar;
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
        int m=grid[0].length;
        if(grid[0][0]==1)
        {
            return -1;
        }
        int res[][]=new int[n][m];
        for(int i[]:res)
        {
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,new int[]{0,0}));
        res[0][0]=0;
        while(pq.size()!=0)
        {
            Pair curr=pq.poll();
            if(curr.dist>res[curr.ar[0]][curr.ar[1]])
            {
                continue;
            }
            for(int dir[]:directions)
            {
                int newrow=curr.ar[0]+dir[0];
                int newcol=curr.ar[1]+dir[1];
                if(newrow<0 || newcol<0 || newrow>=n || newcol>=m || grid[newrow][newcol]==1)
                {
                    continue;
                }
                if(curr.dist+1<res[newrow][newcol])
                {
                    res[newrow][newcol]=curr.dist+1;
                    pq.add(new Pair(res[newrow][newcol],new int[]{newrow,newcol}));
                }
            }
        }
        return res[n-1][m-1]==Integer.MAX_VALUE?-1:res[n-1][m-1]+1;
    }
}