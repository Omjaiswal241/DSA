class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        Boolean dp[][]=new Boolean[n][n];
        return check(s,0,0,dp);
    }
    public boolean check(String s,int idx,int open,Boolean dp[][])
    {
        if(idx==s.length())
        {
            return open==0;
        }
        if(open<0)
        {
            return false;
        }
        if(dp[idx][open]!=null)
        {
            return dp[idx][open];
        }
        char x=s.charAt(idx);
        boolean take=false;
        boolean nottake=false;
        boolean empty=false;
        if(x=='(')
        {
            take=check(s,idx+1,open+1,dp);
        }
        else if(x==')')
        {
            nottake=check(s,idx+1,open-1,dp);
        }
        else
        {
            take=check(s,idx+1,open+1,dp);
            nottake=check(s,idx+1,open-1,dp);
            empty=check(s,idx+1,open,dp);
        }
        return dp[idx][open]=take||nottake||empty;
    }
}