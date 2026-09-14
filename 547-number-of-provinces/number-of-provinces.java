class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j && isConnected[i][j]==1)
                {
                    adj.get(i).add(j);
                }
            }
        }
        boolean visited[]=new boolean[n];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
            {
                cnt++;
                dfs(i,adj,visited);
            }
        }
        return cnt;
    }
    public void dfs(int idx,List<List<Integer>> adj,boolean[] visited)
    {
        visited[idx]=true;
        for(int i:adj.get(idx))
        {
            if(visited[i]==false)
            {
                dfs(i,adj,visited);
            }
        }
    }
}