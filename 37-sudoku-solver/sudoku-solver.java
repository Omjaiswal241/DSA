class Solution {
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
    public boolean helper(char[][] board,int r,int c)
    {
        if(r==9)
        {
            return true;
        }
        int nr=r;
        int nc=c+1;
        if(nc==9)
        {
            nr=r+1;
            nc=0;
        }
        if(board[r][c]!='.')
        {
            return helper(board,nr,nc);
        }
        for(char i='1';i<='9';i++)
        {
            if(issafe(board,r,c,i))
            {
                board[r][c]=i;
                boolean res=helper(board,nr,nc);
                if(res)
                {
                    return true;
                }
                board[r][c]='.';
            }
        }
        return false;
    }
    public boolean issafe(char[][] board,int r,int c,char d)
    {
        int srr=3*(r/3);
        int src=3*(c/3);
        for(int i=0;i<9;i++)
        {
            if(board[r][i]==d)
            {
                return false;
            }
            if(board[i][c]==d)
            {
                return false;
            }
        }
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[srr+i][src+j]==d)
                {
                    return false;
                }
            }
        }
        return true;
    }
}