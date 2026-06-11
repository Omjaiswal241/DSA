class Solution {
    public boolean isMatch(String s, String p) {
        int idx1=s.length()-1;
        int idx2=p.length()-1;
        int dp[][]=new int[idx1+1][idx2+1];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(s,idx1,p,idx2,dp)==1;
    }
    public int helper(String s,int idx1,String p,int idx2,int dp[][])
    {
        if(idx1<0 && idx2<0)
        {
            return 1;
        }
        if(idx1<0)
        {
            for(int i=idx2;i>=0;i--)
            {
                if(p.charAt(i)!='*')
                {
                    return 0;
                }
            }
            return 1;
        }
        if(idx2<0 && idx1>=0)
        {
            return 0;
        }
        if(dp[idx1][idx2]!=-1)
        {
            return dp[idx1][idx2];
        }
        if(s.charAt(idx1)==p.charAt(idx2) || p.charAt(idx2)=='?')
        {
            return dp[idx1][idx2]=helper(s,idx1-1,p,idx2-1,dp);
        }
        else if(p.charAt(idx2)=='*')
        {
            return dp[idx1][idx2]=(helper(s,idx1-1,p,idx2,dp)==1 || helper(s,idx1,p,idx2-1,dp)==1)?1:0;
        }
        return dp[idx1][idx2]=0;
    }
}