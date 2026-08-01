class Solution {
    class Pair
    {
        int vtx,lvl;
        Pair(int vtx,int lvl)
        {
            this.vtx=vtx;
            this.lvl=lvl;
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int visited[]=new int[n];
        Arrays.fill(visited,-1);

        for(int j=0;j<n;j++)
        {
            if(visited[j]!=-1)
            {
                continue;
            }
            Queue<Pair> qu=new ArrayDeque<>();
            qu.add(new Pair(j,0));
            while(qu.size()!=0)
            {
                Pair curr=qu.remove();
                if(visited[curr.vtx]!=-1)
                {
                    if(visited[curr.vtx]%2!=curr.lvl%2)
                    {
                    return false;
                    }
                }
                visited[curr.vtx]=curr.lvl;
                for(int i:graph[curr.vtx])
                {
                    if(visited[i]==-1)
                    {
                        qu.add(new Pair(i,curr.lvl+1));
                    }
                }
            }
        }
        return true;
    }
}