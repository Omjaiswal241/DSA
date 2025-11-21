class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        String str="";
        for(int i=s.length()-1;i>=0;i--)
        {
            str+=s.charAt(i);
        }
        int  dp[][]=new int[n+1][n+1];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return n-helper(s,n-1,str,n-1,dp);
    }
    public int helper(String s,int n,String t,int m,int [][]dp)
    {
        if(n<0 || m<0)
        {
            return 0;
        }
        if(dp[n][m]!=-1)
        {
            return dp[n][m];
        }
        if(s.charAt(n)==t.charAt(m))
        {
            return dp[n][m]=1+helper(s,n-1,t,m-1,dp);
        }
        return dp[n][m]=Math.max(helper(s,n-1,t,m,dp),helper(s,n,t,m-1,dp));
    }
}