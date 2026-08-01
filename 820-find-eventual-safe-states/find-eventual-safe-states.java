class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        boolean visited[]=new boolean[n];
        boolean inRecursion[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
            {
                isCyclicDfs(graph,i,visited,inRecursion);
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(inRecursion[i]==false)
            {
                res.add(i);
            }
        }
        return res;
    }
    public boolean isCyclicDfs(int [][]graph,int i,boolean []visited,boolean inRecursion[])
    {
        visited[i]=true;
        inRecursion[i]=true;
        for(int next:graph[i])
        {
            if(visited[next]==false)
            {
                boolean res=isCyclicDfs(graph,next,visited,inRecursion);
                if(res)
                {
                    return true;
                }
            }
            else
            {
                if(inRecursion[next])
                {
                    return true;
                }
            }
        }
        inRecursion[i]=false;
        return false;
    }
}