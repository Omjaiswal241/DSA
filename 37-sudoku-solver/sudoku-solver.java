class Solution {
    public void solveSudoku(char[][] board) {
        safestate(board,0,0);
    }
    public boolean safestate(char [][]board,int row,int col)
    {
        if(row==9)
        {
            return true;
        }
        int nrow=row;
        int ncol=col+1;
        if(ncol==9)
        {
            nrow=row+1;
            ncol=0;
        }
        if(board[row][col]!='.')
        {
            return safestate(board,nrow,ncol);
        }
        for(char i='1';i<='9';i++)
        {
            if(issafe(board,row,col,i))
            {
                board[row][col]=i;
                boolean res=safestate(board,nrow,ncol);
                if(res)
                {
                    return true;
                }
                board[row][col]='.';
            }
        }
        return false;
    }
    public boolean issafe(char [][]board,int row,int col,char d)
    {
        for(int i=0;i<9;i++)
        {
            if(board[i][col]==d)
            {
                return false;
            }
            if(board[row][i]==d)
            {
                return false;
            }
        }
        int src=3*(row/3);
        int scl=3*(col/3);
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[src+i][scl+j]==d)
                {
                    return false;
                }
            }
        }
        return true;
    }
}