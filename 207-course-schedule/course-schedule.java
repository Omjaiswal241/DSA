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
        boolean inRecursion[]=new boolean[numCourses];
        boolean visited[]=new boolean[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            if(visited[i]==false)
            {
                boolean res=dfs(adj,i,inRecursion,visited);
                if(res)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(List<List<Integer>> adj,int i,boolean inRecursion[],boolean visited[])
    {
        visited[i]=true;
        inRecursion[i]=true;
        for(int next:adj.get(i))
        {
            if(visited[next]==false)
            {
                boolean res=dfs(adj,next,inRecursion,visited);
                if(res)
                {
                    return true;
                }
            }
            else
            {
                if(inRecursion[next]==true)
                {
                    return true;
                }
            }
        }
        inRecursion[i]=false;
        return false;
    }
}