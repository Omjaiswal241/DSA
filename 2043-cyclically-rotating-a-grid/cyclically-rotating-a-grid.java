class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int layers=Math.min(m,n)/2;
        for(int layer=0;layer<layers;layer++)
        {
            List<Integer> li=new ArrayList<>();
            int top=layer;
            int right=n-layer-1;
            int bottom=m-1-layer;
            int left=layer;
            for(int i=left;i<=right;i++)
            {
                li.add(grid[top][i]);
            }
            for(int i=top+1;i<bottom;i++)
            {
                li.add(grid[i][right]);
            }
            for(int i=right;i>=left;i--)
            {
                li.add(grid[bottom][i]);
            }
            for(int i=bottom-1;i>=top+1;i--)
            {
                li.add(grid[i][left]);
            }
            int len=li.size();
            int newk=k%len;
            Collections.rotate(li,-newk);
            int idx=0;
            for(int i=left;i<=right;i++)
            {
                grid[top][i]=li.get(idx);
                idx++;
            }
            for(int i=top+1;i<bottom;i++)
            {
                grid[i][right]=li.get(idx);
                idx++;
            }
            for(int i=right;i>=left;i--)
            {
                grid[bottom][i]=li.get(idx);
                idx++;
            }
            for(int i=bottom-1;i>top;i--)
            {
                grid[i][left]=li.get(idx);
                idx++;
            }
        }
        return grid;
    }
}