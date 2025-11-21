class Solution {
    public int longestPalindromeSubseq(String s) {
        String str="";
        int n=s.length();
       for(int i=n-1;i>=0;i--)
       {
        str+=s.charAt(i);
       } 
       int dp[][]=new int[n+1][n+1];
       for(int []i:dp)
       {
        Arrays.fill(i,-1);
       }
       return lcs(s,n-1,str,n-1,dp);
    }
    public static int lcs(String s1,int n,String s2,int m,int dp[][])
    {
        if(n<0 || m<0)
        {
            return 0;
        }
        if(dp[n][m]!=-1)
        {
            return dp[n][m];
        }
        if(s1.charAt(n)==s2.charAt(m))
        {
            return dp[n][m]=1+lcs(s1,n-1,s2,m-1,dp);
        }
        return dp[n][m]=Math.max(lcs(s1,n-1,s2,m,dp),lcs(s1,n,s2,m-1,dp));
    }
}