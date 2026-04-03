class Solution {
    public int minDistance(String word1, String word2) {
        int idx1=word1.length();
        int idx2=word2.length();
        int dp[][]=new int[idx1][idx2];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(word1,idx1-1,word2,idx2-1,dp);
    }
    public int helper(String s,int idx1,String t,int idx2,int [][]dp)
    {
        if(idx2<0)
        {
            return idx1+1;
        }
        if(idx1<0)
        {
            return idx2+1;
        }
        if(dp[idx1][idx2]!=-1)
        {
            return dp[idx1][idx2];
        }
        if(s.charAt(idx1)==t.charAt(idx2))
        {
            return dp[idx1][idx2]=helper(s,idx1-1,t,idx2-1,dp);
        }
        return dp[idx1][idx2]=1+Math.min(Math.min(helper(s,idx1-1,t,idx2,dp),helper(s,idx1,t,idx2-1,dp)),helper(s,idx1-1,t,idx2-1,dp));
    }
}