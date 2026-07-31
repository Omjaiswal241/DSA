class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        char [][]res=new char[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 || j==0 || i==m-1 || j==n-1)
                {
                    res[i][j]=board[i][j];
                }
                else
                {
                    res[i][j]='X';
                }
            }
        }
        boolean [][] visited=new boolean[m][n];
        for (int j = 0; j < n; j++) 
        {
            if (board[0][j] == 'O' && !visited[0][j])
            {
                dfs(board, 0, j, m, n, res, visited);
            }
            if (board[m - 1][j] == 'O' && !visited[m - 1][j])
            {
                dfs(board, m - 1, j, m, n, res, visited);
            }
        }

        for (int i = 1; i < m - 1; i++) 
        {
            if (board[i][0] == 'O' && !visited[i][0])
            {
                dfs(board, i, 0, m, n, res, visited);
            }
            if (board[i][n - 1] == 'O' && !visited[i][n - 1])
            {
                dfs(board, i, n - 1, m, n, res, visited);
            }    
        }
        for(int i=1;i<m-1;i++)
        {
            for(int j=1;j<n-1;j++)
            {
                board[i][j]=res[i][j];
            }
        }
    }
    public void dfs(char [][]board,int i,int j,int m,int n,char [][]res,boolean visited[][])
    {
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]=='X' || visited[i][j]==true)
        {
            return;
        }
        res[i][j]='O';
        visited[i][j]=true;
        dfs(board,i-1,j,m,n,res,visited);
        dfs(board,i,j-1,m,n,res,visited);
        dfs(board,i+1,j,m,n,res,visited);
        dfs(board,i,j+1,m,n,res,visited);
    }
}