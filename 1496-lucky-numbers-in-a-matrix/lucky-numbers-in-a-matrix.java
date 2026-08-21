class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int row[]=new int[m]; 
        int col[]=new int[n];
        for(int i=0;i<m;i++)
        {
            int cnt=Integer.MAX_VALUE;
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]<cnt)
                {
                    cnt=matrix[i][j];
                }
            }
            row[i]=cnt;
        }
        for(int j=0;j<n;j++)
        {
            int cnt=Integer.MIN_VALUE;
            for(int i=0;i<m;i++)
            {
                if(matrix[i][j]>cnt)
                {
                    cnt=matrix[i][j];
                }
            }
            col[j]=cnt;
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==row[i] && matrix[i][j]==col[j])
                {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}