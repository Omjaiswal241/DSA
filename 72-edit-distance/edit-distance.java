class Solution {
    public int minDistance(String word1, String word2) {
        int idx1=word1.length();
        int idx2=word2.length();
        int dp[][]=new int[idx1][idx2];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return solve(word1,idx1-1,word2,idx2-1,dp);
    }
    public int solve(String s,int idx1,String t,int idx2,int dp[][])
    {
        if(idx1<0 && idx2<0)
        {
            return 0;
        }
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
            return dp[idx1][idx2]=solve(s,idx1-1,t,idx2-1,dp);
        }
        return dp[idx1][idx2]=1+Math.min(solve(s,idx1,t,idx2-1,dp),Math.min(solve(s,idx1-1,t,idx2,dp),solve(s,idx1-1,t,idx2-1,dp)));
    }
}