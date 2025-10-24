class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return haspath(new boolean[n],graph,source,destination);
    }
    public static boolean haspath(boolean [] visited,List<List<Integer>> graph,int src,int dest)
    {
        if(src==dest)
        {
            return true;
        }
        visited[src]=true;
        for(int nbr:graph.get(src))
        {
            if(visited[nbr]==false)
            {
                boolean res=haspath(visited,graph,nbr,dest);
                if(res)
                {
                    return true;
                }
            }
        }
        return false;
    }
}