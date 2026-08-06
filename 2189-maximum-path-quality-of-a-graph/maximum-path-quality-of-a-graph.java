class Solution {
    int ans=0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        List<List<int[]>> adj=new ArrayList<>();
        int n=values.length;
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
        }
        dfs(0,0,0,values,adj,maxTime);
        return ans;
    }
    public void dfs(int src,int currtime,int currval,int []values,List<List<int[]>> adj,int maxTime)
    {
        if(currtime>maxTime)
        {
            return;
        }
        currval+=values[src];
        if(src==0)
        {
            ans=Math.max(currval,ans);
        }
        int temp=values[src];
        values[src]=0;
        for(int next[]:adj.get(src))
        {
            dfs(next[0],currtime+next[1],currval,values,adj,maxTime);
        }
        values[src]=temp;
    }
}