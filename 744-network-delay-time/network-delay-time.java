class Solution {
    class Pair implements Comparable<Pair>
    {
        int vtx,wt;
        Pair(int vtx,int wt)
        {
            this.vtx=vtx;
            this.wt=wt;
        }
        public int compareTo(Pair o)
        {
            return Integer.compare(this.wt,o.wt);
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> li=new ArrayList<>();
        int a=times.length;
        for(int i=0;i<=n;i++)
        {
            li.add(new ArrayList<>());
        }
        for(int i=0;i<a;i++)
        {
            li.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
        }
        int res[]=new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(k,0));
        res[k]=0;
        while(pq.size()!=0)
        {
            Pair curr=pq.poll();
            if(curr.wt>res[curr.vtx])
            {
                continue;
            }
            for(int[] next:li.get(curr.vtx))
            {
                if(curr.wt+next[1]<res[next[0]])
                {
                    res[next[0]]=curr.wt+next[1];
                    pq.add(new Pair(next[0],res[next[0]]));
                }
            }
        }
        int ans=0;
        for(int i=1;i<res.length;i++)
        {
            if(res[i]==Integer.MAX_VALUE)
            {
                return -1;
            }
            if(ans<res[i])
            {
                ans=res[i];
            }
        }
        return ans;
    }
}