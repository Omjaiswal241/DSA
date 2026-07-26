class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        int dp[][]=new int[n][n];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return solve(s,0,0,dp);
    }
    public boolean solve(String s,int idx,int open,int dp[][])
    {
        if(idx==s.length() && open==0)
        {
            return true;
        }
        if(idx==s.length())
        {
            return false;
        }
        if(dp[idx][open]!=-1)
        {
            return dp[idx][open]==1;
        }
        boolean isvalid=false;
        char x=s.charAt(idx);
        if(x=='(')
        {
            isvalid=solve(s,idx+1,open+1,dp);
        }
        else if(x=='*')
        {
            isvalid=solve(s,idx+1,open+1,dp) || solve(s,idx+1,open,dp);
            if(open>=1)
            {
                isvalid=isvalid || solve(s,idx+1,open-1,dp);
            }
        }
        else
        {
            if(open>0)
            {
                isvalid=solve(s,idx+1,open-1,dp);
            }
            else
            {
                return false;
            }
        }
        dp[idx][open]=isvalid?1:0;
        return isvalid;
    }
}