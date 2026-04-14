class Solution {
    public int largestIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int final_res=0;

        int mark=2;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    int size=dfs(grid,i,j,mark);
                    final_res=Math.max(size,final_res);
                    hm.put(mark,size);
                    mark++;
                }
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    HashSet<Integer> hs=new HashSet<>();
                    int f=1;
                    if(i>0)
                    {
                        hs.add(grid[i-1][j]);
                    }
                    if(j>0)
                    {
                        hs.add(grid[i][j-1]);
                    }
                    if(i<m-1)
                    {
                        hs.add(grid[i+1][j]);
                    }
                    if(j<n-1)
                    {
                        hs.add(grid[i][j+1]);
                    }
                    for(int z:hs)
                    {
                        if(z!=0)
                        {
                            f+=hm.get(z);
                        }
                    }
                    final_res=Math.max(final_res,f);
                }
            }
        }
        return final_res;
    }

    public int dfs(int grid[][],int i,int j,int mark)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1)
        {
            return 0;
        }
        grid[i][j]=mark;
        return 1+dfs(grid,i-1,j,mark)+dfs(grid,i,j-1,mark)+dfs(grid,i+1,j,mark)+dfs(grid,i,j+1,mark);
    }
}