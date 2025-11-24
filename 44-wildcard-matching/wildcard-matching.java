class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        int dp[][]=new int [n][m];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return (helper(s,n-1,p,m-1,dp)==1);
    }
    public static int helper(String s,int i,String p,int j,int [][]dp)
    {
        if(i<0 && j<0)
        {
            return 1;
        }
        if(i>=0 && j<0)
        {
            return 0;
        }
        if(i<0 && j>=0)
        {
            for(int f=j;f>=0;f--)
            {
                if(p.charAt(f)!='*')
                {
                    return 0;
                }
            }
            return 1;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
        {
            return dp[i][j]=helper(s,i-1,p,j-1,dp);
        }
        if(p.charAt(j)=='*')
        {
        return dp[i][j]=(helper(s,i-1,p,j,dp)==1 || helper(s,i,p,j-1,dp)==1)?1:0;
        }
        return dp[i][j]=0;
    }
}