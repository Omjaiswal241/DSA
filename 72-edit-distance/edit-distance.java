class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(word1,n,word2,m,dp);
    }
    public static int helper(String s1,int i,String s2,int j,int [][]dp)
    {
        if(i==0)
        {
            return j;
        }
        if(j==0)
        {
            return i;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(s1.charAt(i-1)==s2.charAt(j-1))
        {
            return dp[i][j]=helper(s1,i-1,s2,j-1,dp); //skip
        }
        return dp[i][j]=1+Math.min((helper(s1,i-1,s2,j-1,dp)),Math.min((helper(s1,i,s2,j-1,dp)),(helper(s1,i-1,s2,j,dp))));  //replace,insert,delete
    }
}