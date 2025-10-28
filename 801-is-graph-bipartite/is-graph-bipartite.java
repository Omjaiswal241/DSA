class Solution {
    static class Pair
    {
        int vtx,level;
        Pair(int vtx,int level)
        {
            this.vtx=vtx;
            this.level=level;
        }
    }
    public boolean isBipartite(int[][] graph) {
      int visited[]=new int[graph.length];
      Arrays.fill(visited,-1);
      for(int vtx=0;vtx<graph.length;vtx++)
      {
        if(visited[vtx]==-1)
        {
        boolean res=helper(graph,visited,vtx);
        if(res==false)
        {
            return false;
        }
        }
      }
      return true; 
    }
    public static boolean helper(int [][]graph,int visited[],int vtx)
    {
        Queue<Pair> qu=new ArrayDeque<>();
        qu.add(new Pair(vtx,0));
        while(qu.size()>0)
        {
            Pair front=qu.remove();
            if(visited[front.vtx]==-1)
            {
                visited[front.vtx]=front.level;
                for(int nbr:graph[front.vtx])
                {
                    if(visited[nbr]==-1)
                    {
                        qu.add(new Pair(nbr,front.level+1));
                    }
                }
            }
            else
            {
                if(visited[front.vtx]!=front.level)
                {
                    return  false;
                }
            }
        }
        return true;
    }
}