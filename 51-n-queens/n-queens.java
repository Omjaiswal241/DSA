class Solution {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        helper(new char[n][n],0);
        return res;
    }
    public void helper(char ar[][],int r)
    {
        if(r==ar.length)
        {
            List<String> li=new ArrayList<>();
            for(int i=0;i<ar.length;i++)
            {
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<ar[0].length;j++)
                {
                    if(ar[i][j]!='Q')
                    {
                        sb.append('.');
                    }
                    else
                    {
                        sb.append('Q');
                    }
                }
                li.add(sb.toString());
            }
            res.add(new ArrayList<>(li));
        }
        for(int c=0;c<ar[0].length;c++)
        {
            if(issafe(ar,r,c))
            {
                ar[r][c]='Q';
                helper(ar,r+1);
                ar[r][c]='.';
            }
        }
    }
    public boolean issafe(char ar[][],int r,int c)
    {
        for(int i=r-1,j=c;i>=0;i--)
        {
            if(ar[i][j]=='Q')
            {
                return false;
            }
        }
        for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--)
        {
            if(ar[i][j]=='Q')
            {
                return false;
            }
        }
        for(int i=r-1,j=c+1;i>=0 && j<ar[0].length;i--,j++)
        {
            if(ar[i][j]=='Q')
            {
                return false;
            }
        }
        return true;
    }
}