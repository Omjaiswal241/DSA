class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix[0].length;
        int m=matrix.length;
        int prev[]=new int[n];
        for(int i=0;i<n;i++)
        {
            prev[i]=matrix[m-1][i];
        }
        for(int i=m-2;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                int left=(j>0)?prev[j-1]:Integer.MAX_VALUE;
                int down=prev[j];
                int right=(j<n-1)?prev[j+1]:Integer.MAX_VALUE;
                matrix[i][j]=matrix[i][j]+Math.min(left,Math.min(down,right));
            }
            prev=matrix[i];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            ans=Math.min(ans,matrix[0][i]);
        }
        return ans;
    }
}