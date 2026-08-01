class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int indegree[]=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            for(int j:adj.get(i))
            {
                indegree[j]++;
            }
        }
        List<Integer> li=new ArrayList<>();
        Queue<Integer> qu=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                qu.add(i);
            }
        }
        while(qu.size()!=0)
        {
            int curr=qu.poll();
            li.add(curr);
            for(int j:adj.get(curr))
            {
                indegree[j]--;
                if(indegree[j]==0)
                {
                    qu.add(j);
                }
            }
        }
        int res[]=new int[li.size()];
        for(int i=0;i<li.size();i++)
        {
            res[i]=li.get(i);
        }
        return res.length==numCourses?res:new int[]{};
    }
}