class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j:graph[i])
            {
                adj.get(j).add(i);
            }
        }
        int indegree[]=new int[n];
        for(int i=0;i<n;i++)
        {
            for(int j:adj.get(i))
            {
            indegree[j]++;
            }
        }
        Queue<Integer> qu=new ArrayDeque<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                qu.add(i);
            }
        }
        boolean safestate[]=new boolean[n];
        while(qu.size()!=0)
        {
            int curr=qu.poll();
            safestate[curr]=true;
            for(int i:adj.get(curr))
            {
                indegree[i]--;
                if(indegree[i]==0)
                {
                    qu.add(i);
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(safestate[i])
            {
                res.add(i);
            }
        } 
        return res;
    }
}