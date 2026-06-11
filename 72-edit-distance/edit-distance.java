class Solution {
    public int minDistance(String word1, String word2) {
        int i=word1.length();
        int j=word2.length();
        int dp[][]=new int[i][j];
        for(int f[]:dp)
        {
            Arrays.fill(f,-1);
        }
        return helper(word1,i-1,word2,j-1,dp);
    }
    public int helper(String s,int i,String p,int j,int dp[][])
    {
        if(i<0 && j<0)
        {
            return 0;
        }
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
        if(s.charAt(i)==p.charAt(j))
        {
            return dp[i][j]=helper(s,i-1,p,j-1,dp);
        }
        return dp[i][j]=1+Math.min(helper(s,i-1,p,j-1,dp),Math.min(helper(s,i,p,j-1,dp),helper(s,i-1,p,j,dp)));
    }
}