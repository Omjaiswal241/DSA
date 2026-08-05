class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int indegree[]=new int[n];
        for(int i=0;i<invocations.length;i++)
        {
            indegree[invocations[i][1]]++;
        }
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<invocations.length;i++)
        {
            adj.get(invocations[i][0]).add(invocations[i][1]);
        }
        boolean visited[]=new boolean[n];
        Queue<Integer> qu=new ArrayDeque<>();
        qu.add(k);
        visited[k]=true;
        while(qu.size()!=0)
        {
            int curr=qu.poll();
            for(int next:adj.get(curr))
            {
                if(visited[next]==false)
                {
                    visited[next]=true;
                    qu.add(next);
                }
                indegree[next]--;
            }
        }
        List<Integer> res=new ArrayList<>();
        boolean susremoved=true;
        for(int i=0;i<n;i++)
        {
            if(visited[i]==true)
            {
                if(indegree[i]!=0)
                {
                    susremoved=false;
                    break;
                }
            }
        }
        if(susremoved)
        {
            for(int i=0;i<n;i++)
            {
                if(visited[i]==false)
                {
                    res.add(i);
                }
            }
        }
        else
        {
            for(int i=0;i<n;i++)
            {
                res.add(i);
            }
        }
        return res;
    }
}