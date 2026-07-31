class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean visited[]=new boolean[numCourses];
        boolean inRecursion[]=new boolean[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            if(visited[i]==false)
            {
                boolean res=dfs(adj,i,visited,inRecursion);
                if(res)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(List<List<Integer>> adj,int src,boolean visited[],boolean inRecursion[])
    {
        visited[src]=true;
        inRecursion[src]=true;
        for(int next:adj.get(src))
        {
            if(visited[next]==false)
            {
                boolean res=dfs(adj,next,visited,inRecursion);
                if(res)
                {
                    return true;
                }
            }
            else if(visited[next] && inRecursion[next]==true)
            {
                return true;
            }
        }
        inRecursion[src]=false;
        return false;
    }
}