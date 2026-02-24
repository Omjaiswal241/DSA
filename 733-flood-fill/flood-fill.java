class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original=image[sr][sc];
        helper(image,sr,sc,color,original);
        return image;
    }
    public static void helper(int image[][],int i,int j,int color,int original)
    {
        if(i<0 || j<0 || i>=image.length || j>=image[0].length || image[i][j]==color || image[i][j]!=original)
        {
            return ;
        }
        image[i][j]=color;
        helper(image,i-1,j,color,original);
        helper(image,i,j-1,color,original);
        helper(image,i+1,j,color,original);
        helper(image,i,j+1,color,original);
    }
}