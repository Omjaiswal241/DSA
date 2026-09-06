class Solution {
    public int numDistinct(String s, String t) {
        int idx1=s.length();
        int idx2=t.length();
        int dp[][]=new int[idx1][idx2];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return solve(s,0,t,0,dp);
    }
    public int solve(String s,int idx1,String t,int idx2,int dp[][])
    {
        if(idx2==t.length())
        {
            return 1;
        }
        if(idx1==s.length())
        {
            return 0;
        }
        if(dp[idx1][idx2]!=-1)
        {
            return dp[idx1][idx2];
        }
        int take=0;
        if(s.charAt(idx1)==t.charAt(idx2))
        {
            take=solve(s,idx1+1,t,idx2+1,dp);
        }
        int nottake=solve(s,idx1+1,t,idx2,dp);
        return dp[idx1][idx2]=take+nottake;
    }
}