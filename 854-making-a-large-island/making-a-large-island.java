class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int mark=2;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    int size=dfs(grid,i,j,mark);
                    hm.put(mark,size);
                    mark++;
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    HashSet<Integer> hs=new HashSet<>();
                    if(i>0 && grid[i-1][j]!=0)
                    {
                        hs.add(grid[i-1][j]);
                    }
                    if(j>0 && grid[i][j-1]!=0)
                    {
                        hs.add(grid[i][j-1]);
                    }
                    if(i<n-1 && grid[i+1][j]!=0)
                    {
                        hs.add(grid[i+1][j]);
                    }
                    if(j<n-1 && grid[i][j+1]!=0)
                    {
                        hs.add(grid[i][j+1]);
                    }
                    int res=0;
                    for(int val:hs)
                    {
                        res+=hm.get(val);
                    }
                    ans=Math.max(ans,res+1);
                }
            }
        }
        return ans==0?(n*n):ans;
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