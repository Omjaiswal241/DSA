class Solution {
    public int numSpecial(int[][] mat) {
        int count=0;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==1)
                {
                if(check(mat,i,j))
                {
                    count++;
                }
                }
            }
        }
        return count;
    }
    public static boolean check(int [][]mat,int i,int j)
    {
        for(int r=i,c=0;c<mat[0].length;c++)
        {
            if(r!=i || c!=j)
            {
                if(mat[r][c]==1)
                {
                    return false;
                }
            }
        }
        for(int r=0,c=j;r<mat.length;r++)
        {
            if(r!=i || c!=j)
            {
                if(mat[r][c]==1)
                {
                    return false;
                }
            }
        }
        return true;
    }
}