class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res=new ArrayList<>();
        int m=grid.length;
        int n=grid[0].length;
        int ele=m*n;
        k=k%ele;
        int f=0;
        for(int i=ele-k;i<ele;i++)
        {
            int row=i/n;
            int col=i%n;
            if(f==0)
            {
                res.add(new ArrayList<>());
            }
            res.get(res.size()-1).add(grid[row][col]);
            f++;
            if(f==n)
            {
                f=0;
            }
        }
        for(int i=0;i<ele-k;i++)
        {
            int row=i/n;
            int col=i%n;
            if(f==0)
            {
                res.add(new ArrayList<>());
            }
            res.get(res.size()-1).add(grid[row][col]);
            f++;
            if(f==n)
            {
                f=0;
            }
        }
        return res;
    }
}