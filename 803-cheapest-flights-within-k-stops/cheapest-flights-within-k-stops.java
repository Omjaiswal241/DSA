class Solution {
    class Pair
    {
        int vtx,wt;
        Pair(int vtx,int wt)
        {
            this.vtx=vtx;
            this.wt=wt;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++)
        {
            adj.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }
        int res[]=new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);
        Queue<int[]> qu=new ArrayDeque<>();
        qu.add(new int[]{0,src,0});
        res[src]=0;
        while(qu.size()!=0)
        {
            int curr[]=qu.poll();
            int stops=curr[0];
            int vtx=curr[1];
            int wt=curr[2];
            if(stops>k)
            {
                continue;
            }
            for(int []next:adj.get(vtx))
            {
                if(wt+next[1]<res[next[0]])
                {
                    res[next[0]]=wt+next[1];
                    qu.add(new int[]{stops+1,next[0],res[next[0]]});
                }
            }
        }
        return res[dst]==Integer.MAX_VALUE?-1:res[dst];
    }
}