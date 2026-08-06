class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][]=new int[n][n];
        for(int i[]:dist)
        {
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++)
        {
            dist[i][i]=0;
        }
        for(int i=0;i<edges.length;i++)
        {
            dist[edges[i][0]][edges[i][1]]=edges[i][2];
            dist[edges[i][1]][edges[i][0]]=edges[i][2];
        }
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE)
                    {
                        continue;
                    }
                    else if(dist[i][j]==Integer.MAX_VALUE)
                    {
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                    else
                    {
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        int ans=0;
        int min_path=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            int path=0;
            for(int j=0;j<n;j++)
            {
                if(dist[i][j]<=distanceThreshold)
                {
                    path++;
                }
            }
            if(min_path>=path)
            {
                min_path=path;
                ans=i;
            }
        }
        return ans;
    }
}