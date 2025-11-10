class Solution {
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
    public static boolean solve(char[][] board,int row,int col)
    {
        for(int r=0;r<board.length;r++)
        {
            for(int c=0;c<board[0].length;c++)
            {
                if(board[r][c]=='.')
                {
                for(char i='1';i<='9';i++)
                {
                    if(issafe(board,r,c,i))
                    {
                        board[r][c]=i;
                        if(solve(board,r,c)==true)
                        {
                            return true;
                        }
                        else
                        {
                            board[r][c]='.';
                        }
                    }
                }
                return false;
                }
            }
        }
        return true;
    }
    public static boolean issafe(char [][]board,int row,int col,char c)
    {
        for(int i=0;i<9;i++)
        {
            if(board[i][col]==c)
            {
                return false;
            }
            if(board[row][i]==c)
            {
                return false;
            }
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c)
            {
                return false;
            }
        }
        return true;
    }
}