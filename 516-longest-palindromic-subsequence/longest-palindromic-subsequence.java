class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        String t=reverse(s);
        int dp[][]=new int[n][n];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(s,n-1,t,n-1,dp);
    }
    public int helper(String str1,int idx1,String str2,int idx2,int dp[][])
    {
        if(idx1<0 || idx2<0)
        {
            return 0;
        }
        if(dp[idx1][idx2]!=-1)
        {
            return dp[idx1][idx2];
        }
        if(str1.charAt(idx1)==str2.charAt(idx2))
        {
            return dp[idx1][idx2]=1+helper(str1,idx1-1,str2,idx2-1,dp);
        }
        return dp[idx1][idx2]=Math.max(helper(str1,idx1-1,str2,idx2,dp),helper(str1,idx1,str2,idx2-1,dp));
    }
    public String reverse(String s)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--)
        {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}