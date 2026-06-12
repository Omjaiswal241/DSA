class Solution {
    public int minCut(String s) {
       int n=s.length();
       int dp[]=new int[n];
       Arrays.fill(dp,-1);
       return helper(s,0,dp)-1; 
    }
    public int helper(String s,int idx,int []dp)
    {
        if(idx==s.length())
        {
            return 0;
        }
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        int min_cost=Integer.MAX_VALUE;
        for(int i=idx;i<s.length();i++)
        {
            if(ispalin(s,idx,i))
            {
                int cost=1+helper(s,i+1,dp);
                min_cost=Math.min(min_cost,cost);
            }
        }
        return dp[idx]=min_cost;
    }
    public boolean ispalin(String s,int idx,int i)
    {
        int l=idx,h=i;
        while(l<h)
        {
            if(s.charAt(l)!=s.charAt(h))
            {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
}