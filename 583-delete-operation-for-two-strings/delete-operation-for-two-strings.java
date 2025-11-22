class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n][m];
        for(int []i:dp)
        {
            Arrays.fill(i,-1);
        }
        int temp=n+m;
        return temp-2*lcs(word1,n-1,word2,m-1,dp);
    }
    public static int lcs(String str1,int idx1,String str2,int idx2,int dp[][])
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
            return dp[idx1][idx2]=1+lcs(str1,idx1-1,str2,idx2-1,dp);
        }
        return dp[idx1][idx2]=Math.max(lcs(str1,idx1-1,str2,idx2,dp),lcs(str1,idx1,str2,idx2-1,dp));
    }
}