class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<Integer>());
        }
        for(int[] edge:edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return haspath(new boolean[n],graph,source,destination);
    }
    public static boolean haspath(boolean visited[],List<List<Integer>> graph,int src,int dest)
    {
        if(src==dest)
        {
            return true;
        }
        visited[src]=true;
        for(int neighbour:graph.get(src))
        {
            if(visited[neighbour]==false)
            {
                boolean res=haspath(visited,graph,neighbour,dest);
                if(res)
                {
                    return true;
                }
            }
        }
        return false;
    }
}