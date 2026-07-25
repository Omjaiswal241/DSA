class Solution {
    int cnt=0;
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean visited[]=new boolean[n];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    graph.get(i).add(j);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
            {
                cnt++;
                dfs(graph,i,visited);
            }
        }
        return cnt;
    }
    public void dfs(List<List<Integer>> graph,int src,boolean[] visited)
    {
        visited[src]=true;
        for(int i=0;i<graph.get(src).size();i++)
        {
            if(visited[graph.get(src).get(i)]==false)
            {
                dfs(graph,graph.get(src).get(i),visited);
            }
        }
    }
}