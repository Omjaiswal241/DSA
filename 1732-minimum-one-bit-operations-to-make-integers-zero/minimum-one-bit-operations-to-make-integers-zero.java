class Solution {
    public int minimumOneBitOperations(int n) {
        if(n==0)
        {
            return 0;
        }
        int dp[]=new int[31];
        dp[0]=1;
        for(int i=1;i<=30;i++)
        {
            dp[i]=2*dp[i-1]+1;
        }
        int result=0;
        boolean sign=true;
        for(int i=30;i>=0;i--)
        {
            boolean setbit=(n&(1<<i))!=0;
            if(setbit)
            {
                if(sign)
                {
                    result+=dp[i];
                    sign=false;
                }
                else
                {
                    result-=dp[i];
                    sign=true;
                }
            }
        }
        return result;
    }
}