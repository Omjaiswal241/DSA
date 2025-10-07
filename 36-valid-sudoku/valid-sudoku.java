class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(!isvalid(i,j,board))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isvalid(int r,int c,char [][]ar)
    {
        if(ar[r][c]=='.')
        {
            return true;
        }
        for(int i=0;i<9;i++)
        {
            if(i!=r && ar[i][c]==ar[r][c])
            {
                return false;
            }
            if(i!=c && ar[r][i]==ar[r][c])
            {
                return false;
            }
            if(3*(r/3)+i/3!=r && 3*(c/3)+i%3!=c && ar[3*(r/3)+i/3][3*(c/3)+i%3]==ar[r][c])
            {
                return false;
            }
        }
        return true;
    }
}