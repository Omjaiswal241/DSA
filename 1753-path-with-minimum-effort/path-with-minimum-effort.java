class Solution {
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
    int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int n=heights.length;
        int m=heights[0].length;
        int res[][]=new int[n][m];
        for(int i[]:res)
        {
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        pq.add(new Pair(0,new int[]{0,0}));
        res[0][0]=0;
        while(pq.size()!=0)
        {
            Pair curr=pq.poll();
            int row=curr.ar[0];
            int col=curr.ar[1];
            if(curr.dist>res[row][col])
            {
                continue;
            }
            for(int dir[]:directions)
            {
                int newrow=row+dir[0];
                int newcol=col+dir[1];
                if(newrow<0 || newcol<0 || newrow>=n || newcol>=m)
                {
                    continue;
                }
                int temp=Math.abs(heights[newrow][newcol]-heights[row][col]);
                int val=Math.max(res[row][col],temp);
                if(val<res[newrow][newcol])
                {
                    res[newrow][newcol]=val;
                    pq.add(new Pair(val,new int[]{newrow,newcol}));
                }
            }
        }
        return res[n-1][m-1];
    }
}