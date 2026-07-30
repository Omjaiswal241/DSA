class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original_clr=image[sr][sc];
        dfs(image,sr,sc,color,original_clr,new boolean[image.length][image[0].length]);
        return image;
    }
    public void dfs(int [][]image,int sr,int sc,int color,int original_clr,boolean [][]visited)
    {
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=original_clr || visited[sr][sc]==true)
        {
            return ;
        }
        image[sr][sc]=color;
        visited[sr][sc]=true;
        dfs(image,sr-1,sc,color,original_clr,visited);
        dfs(image,sr,sc-1,color,original_clr,visited);
        dfs(image,sr+1,sc,color,original_clr,visited);
        dfs(image,sr,sc+1,color,original_clr,visited);
    }
}