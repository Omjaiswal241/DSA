class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        int visited[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                char z=board[i][j];
                if(z==word.charAt(0))
                {
                    boolean res=helper(board,0,i,j,visited,word);
                    if(res)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean helper(char [][]board,int idx,int r,int c,int [][]visited,String word)
    {
        if(idx==word.length())
        {
            return true;
        }
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || visited[r][c]==1 || board[r][c]!=word.charAt(idx))
        {
            return false;
        }
        visited[r][c]=1;
        boolean top=helper(board,idx+1,r-1,c,visited,word);
        boolean left=helper(board,idx+1,r,c-1,visited,word);
        boolean down=helper(board,idx+1,r+1,c,visited,word);
        boolean right=helper(board,idx+1,r,c+1,visited,word);
        visited[r][c]=0;
        return top || left || down || right;
    }
}