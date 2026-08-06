class Solution {
    int MOD=1000000007;
    class Pair implements Comparable<Pair>
    {
        int vtx;
        long wt;
        Pair(int vtx,long wt)
        {
            this.vtx=vtx;
            this.wt=wt;
        }
        public int compareTo(Pair o)
        {
            return Long.compare(this.wt,o.wt);
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++)
        {
            adj.get(roads[i][0]).add(new int[]{roads[i][1],roads[i][2]});
            adj.get(roads[i][1]).add(new int[]{roads[i][0],roads[i][2]});
        }

        long dist[]=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        long count[]=new long[n];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,0));
        dist[0]=0;
        count[0]=1;
        while(pq.size()!=0)
        {
            Pair curr=pq.poll();
            int node=curr.vtx;
            long cost=curr.wt;
            if(dist[node]<cost)
            {
                continue;
            }
            for(int next[]:adj.get(node))
            {
                if(dist[next[0]]>cost+next[1])
                {
                    dist[next[0]]=cost+next[1];
                    pq.add(new Pair(next[0],dist[next[0]]));
                    count[next[0]]=count[node];
                }
                else if(dist[next[0]]==cost+next[1])
                {
                    count[next[0]]=(count[next[0]]+count[node])%MOD;
                }
            }
        }
        return (int)count[n-1];
    }
}