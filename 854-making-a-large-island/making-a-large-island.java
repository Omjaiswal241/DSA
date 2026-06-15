class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int mark=1;
        int res=Integer.MIN_VALUE;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    mark++;
                    int size=helper(grid,i,j,mark);
                    res=Math.max(size,res);
                    hm.put(mark,size);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    int g=1;
                    HashSet<Integer> hs=new HashSet<>();
                    if(i>0)
                    {
                        hs.add(grid[i-1][j]);
                    }
                    if(j>0)
                    {
                        hs.add(grid[i][j-1]);
                    }
                    if(i<n-1)
                    {
                        hs.add(grid[i+1][j]);
                    }
                    if(j<n-1)
                    {
                        hs.add(grid[i][j+1]);
                    }
                    for(int f:hs)
                    {
                        if(f!=0)
                        {
                            g+=hm.get(f);
                        }                        
                    }
                    res=Math.max(res,g);
                }
            }
        }
        return res;
    }
    public int helper(int grid[][],int i,int j,int mark)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid.length || grid[i][j]!=1)
        {
            return 0;
        }
        grid[i][j]=mark;
        return 1+helper(grid,i-1,j,mark)+helper(grid,i,j-1,mark)+helper(grid,i+1,j,mark)+helper(grid,i,j+1,mark);
    }
}