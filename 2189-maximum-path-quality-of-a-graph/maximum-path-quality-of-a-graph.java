class Solution {
    int ans=0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n=values.length;
        List<List<int[]>> li=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            li.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            li.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            li.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
        }
        dfs(0,0,0,values,maxTime,li);
        return ans;
    }
    public void dfs(int src,int currval,int currtime,int[] values,int maxTime,List<List<int[]>> li)
    {
        if(currtime>maxTime)
        {
            return ;
        }
        currval+=values[src];
        if(src==0)
        {
            ans=Math.max(ans,currval);
        }
        int temp=values[src];
        values[src]=0;
        for(int i=0;i<li.get(src).size();i++)
        {
            int a[]=li.get(src).get(i);
            dfs(a[0],currval,currtime+a[1],values,maxTime,li);
        }
        values[src]=temp;
    }
}