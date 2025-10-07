class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> li=new ArrayList<List<String>>();
        char [][] chess=new char[n][n];
        nQueens(chess,0,li);
        return li;
    }
    public static void nQueens(char [][]chess,int row,List<List<String>> li)
    {
        if(row==chess.length)
        {
            savestr(chess,li);
            return;
        }
        for(int col=0;col<chess[0].length;col++)
        {
            if(issafe(chess,row,col))
            {
                chess[row][col]='Q';
                nQueens(chess,row+1,li);
                chess[row][col]='.';
            }
        }
    }
    public static boolean issafe(char [][] chess, int r, int c)
    {
        for(int i=r-1,j=c;i>=0;i--)
        {
            if(chess[i][j]=='Q')
            {
                return false;
            }
        }
        for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--)
        {
            if(chess[i][j]=='Q')
            {
                return false;
            }
        }
        for(int i=r-1,j=c+1;i>=0 && j<chess[0].length;i--,j++)
        {
            if(chess[i][j]=='Q')
            {
                return false;
            }
        }
        return true;
    }
    public static void savestr(char [][]chess,List<List<String>> li)
    {
        List<String> temp=new ArrayList<>();
        for(int i=0;i<chess.length;i++)
        {
            String row="";
            for(int j=0;j<chess[0].length;j++)
            {
                if(chess[i][j]=='Q')
                {
                    row+='Q';
                }
                else
                {
                    row+='.';
                }
            }
            temp.add(row);
        }
        li.add(temp);
    }
}