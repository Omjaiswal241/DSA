class Solution {
    public int minDistance(String word1, String word2) {
        int idx1=word1.length();
        int idx2=word2.length();
        int dp[][]=new int[idx1][idx2];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(word1,idx1-1,word2,idx2-1,dp);
    }
    public int helper(String s,int i,String t,int j,int [][]dp)
    {
        if(i<0 && j<0)
        {
            return 0;
        }
        if(i<0)
        {
            return j+1; 
        }
        if(j<0)
        {
            return i+1;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(s.charAt(i)==t.charAt(j))
        {
            return dp[i][j]=helper(s,i-1,t,j-1,dp);
        }
        return dp[i][j]=Math.min(1+helper(s,i-1,t,j-1,dp),Math.min(1+helper(s,i,t,j-1,dp),1+helper(s,i-1,t,j,dp)));
    }
}