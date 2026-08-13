class Solution {
    public void solveSudoku(char[][] board) {
        solve(0,0,board);
    }
    public boolean solve(int r,int c,char [][]board)
    {
        if(r==9)
        {
            return true;
        }
        int nc=c+1;
        int nr=r;
        if(nc==9)
        {
            nr=r+1;
            nc=0;
        }
        if(board[r][c]!='.')
        {
            return solve(nr,nc,board);
        }
        for(char i='1';i<='9';i++)
        {
            if(check(board,i,r,c))
            {
                board[r][c]=i;
                boolean res=solve(nr,nc,board);
                if(res)
                {
                    return true;
                }
            }
            board[r][c]='.';
        }
        return false;
    }
    public boolean check(char board[][],char curr,int r,int c)
    {
        for(int i=0;i<9;i++)
        {
            if(board[r][i]==curr)
            {
                return false;
            }
            if(board[i][c]==curr)
            {
                return false;
            }
        }
        int row=3*(r/3);
        int col=3*(c/3);
        for(int i=row;i<row+3;i++)
        {
            for(int j=col;j<col+3;j++)
            {
                if(board[i][j]==curr)
                {
                    return false;
                }
            }
        }
        return true;
    }
}