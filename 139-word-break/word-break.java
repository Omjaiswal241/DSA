class Solution {
    Boolean []dp;
    int n;
    public boolean wordBreak(String s, List<String> wordDict) {
        n=s.length();
        dp=new Boolean[n];
        HashSet<String> hs=new HashSet<>();
        for(String str:wordDict)
        {
            hs.add(str);
        }
        return solve(s,0,wordDict,hs);
    }
    public boolean solve(String s,int idx,List<String> wordDict,HashSet<String> hs)
    {
        if(idx==n)
        {
            return true;
        }
        if(dp[idx]!=null)
        {
            return dp[idx];
        }
        for(int endidx=idx+1;endidx<=n;endidx++)
        {
            String temp=s.substring(idx,endidx);
            if(hs.contains(temp) && solve(s,endidx,wordDict,hs))
            {
                return dp[idx]=true;
            }
        }
        return dp[idx]=false;
    }
}