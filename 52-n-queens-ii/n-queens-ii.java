class Solution {
    public int totalNQueens(int n) {
        int chess[][]=new int[n][n];
        List<String> li=new ArrayList<>();
        nQueens(chess,0,"",li);
        return li.size();
    }
    public static void nQueens(int chess[][],int row,String psf,List<String> li)
    {
        if(row==chess.length)
        {
            li.add(psf);
            return;
        }
        for(int col=0;col<chess[0].length;col++)
        {
            if(isSafe(chess,row,col))
            {
                chess[row][col]=1;
                nQueens(chess,row+1,psf+row+"-"+col+",",li);
                chess[row][col]=0;
            }
        }
    }
    public static boolean isSafe(int chess[][],int r,int c)
    {
        for(int i=r-1,j=c;i>=0;i--)
        {
            if(chess[i][j]==1)
            {
                return false;
            }
        }
        for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--)
        {
            if(chess[i][j]==1)
            {
                return false;
            }
        }
        for(int i=r-1,j=c+1;i>=0 && j<chess[0].length;i--,j++)
        {
            if(chess[i][j]==1)
            {
                return false;
            }
        }
        return true;
    }
}