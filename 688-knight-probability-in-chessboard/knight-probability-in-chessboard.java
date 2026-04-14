class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double dp[][][]=new double[n][n][k+1];
        for(double layers[][]:dp)
        {
            for(double i[]:layers)
            {
                Arrays.fill(i,-1.0);
            }
        }
        return helper(n,k,row,column,dp);
    }
    public double helper(int n,int k,int row,int column,double dp[][][])
    {
        if(row<0 || row>=n || column<0 || column>=n)
        {
            return 0;
        }
        if(k==0)
        {
            return 1;
        }
        if(dp[row][column][k]!=-1.0)
        {
            return dp[row][column][k];
        }
        double res=helper(n,k-1,row-2,column-1,dp)+
        helper(n,k-1,row-1,column-2,dp)+
        helper(n,k-1,row+1,column-2,dp)+
        helper(n,k-1,row+2,column-1,dp)+
        helper(n,k-1,row+2,column+1,dp)+
        helper(n,k-1,row+1,column+2,dp)+
        helper(n,k-1,row-1,column+2,dp)+
        helper(n,k-1,row-2,column+1,dp);
        return dp[row][column][k]=(double)(res/8.0);
    }
}