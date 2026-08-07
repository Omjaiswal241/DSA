class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m=connections.length;
        if(n-1>m)
        {
            return -1;
        }
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        boolean visited[]=new boolean[n];
        int components=0;
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
            {
                components++;
                Queue<Integer> qu=new ArrayDeque<>();
                qu.add(i);
                while(qu.size()!=0)
                {
                    int curr=qu.poll();
                    if(visited[curr]==false)
                    {
                        visited[curr]=true;
                        for(int next:adj.get(curr))
                        {
                            if(visited[next]==false)
                            {
                                qu.add(next);
                            }
                        }
                    }
                }
            }
        }
        return components-1;
    }
}