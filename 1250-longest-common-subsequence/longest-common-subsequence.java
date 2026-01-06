class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int dp[][]=new int[n][m];
        for(int []i:dp)
        {
            Arrays.fill(i,-1);
        }
        return lcs(text1,n-1,text2,m-1,dp);
    }
    public int lcs(String s,int i,String t,int j,int [][]dp)
    {
        if(i<0 || j<0)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(s.charAt(i)==t.charAt(j))
        {
            return dp[i][j]=1+lcs(s,i-1,t,j-1,dp);
        }
        return dp[i][j]=Math.max(lcs(s,i-1,t,j,dp),lcs(s,i,t,j-1,dp));
    }
}