class Solution {
    public int minCut(String s) {
        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return countmin(0,s,dp)-1;
    }
    public static int countmin(int idx,String s,int dp[])
    {
        if(idx==s.length())
        {
            return 0;
        }
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        int mincuts=Integer.MAX_VALUE;
        for(int i=idx;i<s.length();i++)
        {
            if(ispalin(s,idx,i))
            {
                int count=1+countmin(i+1,s,dp);
                mincuts=Math.min(count,mincuts);
            }
        }
        return dp[idx]=mincuts;
    }
    public static boolean ispalin(String s,int start,int end)
    {
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}