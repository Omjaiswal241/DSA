class Solution {
    public String[] createGrid(int m, int n) {
        char ar[][]=new char[m][n];
        for(char i[]:ar)
        {
            Arrays.fill(i,'#');
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 || j==n-1)
                {
                    ar[i][j]='.';
                }
            }
        }
        String res[]=new String[m];
        for(int i=0;i<m;i++)
        {
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++)
            {
                sb.append(ar[i][j]);
            }
            res[i]=sb.toString();
        }
        return res;
    }
}