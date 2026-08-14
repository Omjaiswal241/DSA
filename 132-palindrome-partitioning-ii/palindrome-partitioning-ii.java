class Solution {
    public int minCut(String s) {
        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return helper(s,0,dp)-1;
    }
    public int helper(String s,int idx,int dp[])
    {
        if(idx==s.length())
        {
            return 0;
        }
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        int cuts=Integer.MAX_VALUE;
        for(int i=idx;i<s.length();i++)
        {
            if(ispalin(s.substring(idx,i+1)))
            {
                cuts=Math.min(cuts,1+helper(s,i+1,dp));
            }
        }
        return dp[idx]=cuts;
    }
    public boolean ispalin(String s)
    {
        int low=0,high=s.length()-1;
        while(low<high)
        {
            if(s.charAt(low)!=s.charAt(high))
            {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}