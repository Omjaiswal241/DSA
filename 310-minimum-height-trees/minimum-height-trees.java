class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> li=new ArrayList<>();
        if(n==1)
        {
            li.add(0);
            return li;
        }
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        int indegree[]=new int[n];
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            indegree[u]++;
            indegree[v]++;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> qu=new ArrayDeque<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==1)
            {
                qu.add(i);
            }
        }
        int remaining=n;
        while(remaining>2)
        {
            int size=qu.size();
            remaining-=size;
            while(size-->0)
            {
                int curr=qu.poll();
                for(int next:adj.get(curr))
                {
                    indegree[next]--;
                    if(indegree[next]==1)
                    {
                        qu.add(next);
                    }
                }
            }
        }
        while(qu.size()!=0)
        {
            li.add(qu.poll());
        }
        return li;
    }
}