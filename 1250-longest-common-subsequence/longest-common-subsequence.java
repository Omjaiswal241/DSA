class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1=text1.length();
        int l2=text2.length();
        int dp[][]=new int[l1][l2];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return lcs(text1,l1-1,text2,l2-1,dp);
    }
    public int lcs(String s,int l1,String p,int l2,int [][]dp)
    {
        if(l1<0 || l2<0)
        {
            return 0;
        }
        if(dp[l1][l2]!=-1)
        {
            return dp[l1][l2];
        } 
        if(s.charAt(l1)==p.charAt(l2))
        {
            return dp[l1][l2]=1+lcs(s,l1-1,p,l2-1,dp);
        }
        return dp[l1][l2]=Math.max(lcs(s,l1-1,p,l2,dp),lcs(s,l1,p,l2-1,dp));
    }
}