class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        HashSet<String> hs=new HashSet<>();
        for(String i:wordDict)
        {
            hs.add(i);
        }
        return helper(s,hs,0,dp)==1;
    }
    public int helper(String s,HashSet<String> hs,int idx,int dp[])
    {
        if(idx==s.length())
        {
            return 1;
        }
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        for(int i=idx;i<s.length();i++)
        {
            if(hs.contains(s.substring(idx,i+1)))
            {
                dp[idx]=helper(s,hs,i+1,dp);
            }
            if(dp[idx]==1)
            {
                return dp[idx];
            }
        }
        return dp[idx]=0;
    }
}