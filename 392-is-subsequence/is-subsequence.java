class Solution {
    public boolean isSubsequence(String s, String t) {
        int idx1=s.length();
        int idx2=t.length();
        int dp[][]=new int[idx1][idx2];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(s,idx1-1,t,idx2-1,dp)==1;
    }
    public int helper(String s,int idx1,String p,int idx2,int dp[][])
    {
        if(idx1<0)
        {
            return 1;
        }
        if(idx2<0)
        {
            return 0;
        }
        if(dp[idx1][idx2]!=-1)
        {
            return dp[idx1][idx2];
        }
        if(s.charAt(idx1)==p.charAt(idx2))
        {
            return dp[idx1][idx2]=helper(s,idx1-1,p,idx2-1,dp);
        }
        return dp[idx1][idx2]=helper(s,idx1,p,idx2-1,dp);
    }
}