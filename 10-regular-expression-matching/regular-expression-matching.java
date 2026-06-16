class Solution {
    public boolean isMatch(String s, String p) {
        int idx1=s.length();
        int idx2=p.length();
        int dp[][]=new int[idx1][idx2];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(s,idx1-1,p,idx2-1,dp)==1;
    }
    public int helper(String s,int idx1,String p,int idx2,int dp[][])
    {
        if(idx1<0 && idx2<0)
        {
            return 1;
        }
        if(idx1<0)
        {
            for(int i=0;i<=idx2;i=i+2)
            {
                if(i+1>idx2 || p.charAt(i+1)!='*')
                {
                    return 0;
                }
            }
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
        if(s.charAt(idx1)==p.charAt(idx2) || p.charAt(idx2)=='.')
        {
            return dp[idx1][idx2]=helper(s,idx1-1,p,idx2-1,dp);
        }
        else if(p.charAt(idx2)=='*')
        {
            if(idx2==0)
            {
                return 0;
            }
            int nottake=helper(s,idx1,p,idx2-2,dp);
            int take=0;
            if(p.charAt(idx2-1)==s.charAt(idx1) || p.charAt(idx2-1)=='.')
            {
                take=helper(s,idx1-1,p,idx2,dp);
            }
            return dp[idx1][idx2]=(take==1 || nottake==1)?1:0;
        }
        return dp[idx1][idx2]=0;
    }
}