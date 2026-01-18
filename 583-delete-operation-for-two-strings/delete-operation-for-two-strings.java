class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int tot_len=n+m;
        int dp[][]=new int[n][m];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        int match=lcs(word1,n-1,word2,m-1,dp);
        return tot_len-2*match;
    }
    public int lcs(String s,int idx1,String t,int idx2,int dp[][])
    {
        if(idx1<0 || idx2<0)
        {
            return 0;
        }
        if(dp[idx1][idx2]!=-1)
        {
            return dp[idx1][idx2];
        }
        if(s.charAt(idx1)==t.charAt(idx2))
        {
            return dp[idx1][idx2]=1+lcs(s,idx1-1,t,idx2-1,dp);
        }
        return dp[idx1][idx2]=Math.max(lcs(s,idx1-1,t,idx2,dp),lcs(s,idx1,t,idx2-1,dp));
    }
}