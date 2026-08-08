class Solution {
    int timer=1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.size();i++)
        {
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        int dt[]=new int[n];
        int low[]=new int[n];
        List<List<Integer>> bridges=new ArrayList<>();
        dfs(0,-1,new boolean[n],adj,dt,low,bridges);
        return bridges;
    }
    public void dfs(int node,int pnode,boolean visited[],List<List<Integer>> adj,int dt[],int low[],List<List<Integer>> bridges)
    {
        visited[node]=true;
        dt[node]=low[node]=timer++;
        for(int nbr:adj.get(node))
        {
            if(pnode==nbr)
            {
                continue;
            }
            if(visited[nbr]==false)
            {
                dfs(nbr,node,visited,adj,dt,low,bridges);
                low[node]=Math.min(low[node],low[nbr]);
                if(low[nbr]>dt[node])
                {
                    List<Integer> temp=new ArrayList<>();
                    temp.add(node);
                    temp.add(nbr);
                    bridges.add(new ArrayList<>(temp));
                }
            }
            else
            {
                low[node]=Math.min(low[nbr],low[node]);
            }
        }
    }
}