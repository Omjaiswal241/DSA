class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        int ar[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    boolean res=helper(board,i,j,word,0,ar);
                    if(res)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean helper(char [][]board,int i,int j,String s,int idx,int ar[][])
    {
        if(idx==s.length())
        {
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || ar[i][j]==1 || board[i][j]!=s.charAt(idx))
        {
            return false;
        }
        ar[i][j]=1;
        boolean top=helper(board,i-1,j,s,idx+1,ar);
        boolean left=helper(board,i,j-1,s,idx+1,ar);
        boolean bottom=helper(board,i+1,j,s,idx+1,ar);
        boolean right=helper(board,i,j+1,s,idx+1,ar);
        ar[i][j]=0;
        return top || left ||bottom || right;
    }
}