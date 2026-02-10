class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n][m];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(word1,n-1,word2,m-1,dp);
    }
    public static int helper(String s,int i,String t,int j,int [][]dp)
    {
        if(i<0)
        {
            return j+1;
        }
        if(j<0)
        {
            return i+1;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(s.charAt(i)==t.charAt(j))
        {
            return dp[i][j]=helper(s,i-1,t,j-1,dp);
        }
        return dp[i][j]=Math.min(Math.min(1+helper(s,i-1,t,j-1,dp),1+helper(s,i-1,t,j,dp)),(1+helper(s,i,t,j-1,dp)));
    }
}