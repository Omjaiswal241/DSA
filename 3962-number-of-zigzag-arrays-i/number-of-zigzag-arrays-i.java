class Solution {
    int MOD=1000000007;
    int N,M;
    public int zigZagArrays(int n, int l, int r) {
        N=n;
        M=r-l+1;
        long dp[][][]=new long[N+1][M+1][2];
        for(int prev=1;prev<=M;prev++)
        {
            dp[N][prev][0]=1;
            dp[N][prev][1]=1;
        }
        for(int i=N-1;i>=0;i--)
        {
            long cumsum1[]=new long[M+1];
            long cumsum0[]=new long[M+1];
            for(int val=1;val<=M;val++)
            {
                cumsum1[val]=(cumsum1[val-1]+dp[i+1][val][1])%MOD;
                cumsum0[val]=(cumsum0[val-1]+dp[i+1][val][0])%MOD;
            }
            for(int prev=1;prev<=M;prev++)
            {
                // for(int nextval=prev+1;nextval<=M;nextval++)      //increasing
                // {
                //     dp[i][prev][1]=(dp[i][prev][1]+dp[i+1][nextval][0])%MOD;
                // }
                dp[i][prev][1]=(cumsum0[M]-cumsum0[prev]+MOD)%MOD;
                // for(int nextval=1;nextval<prev;nextval++)        //decreasing
                // {
                //     dp[i][prev][0]=(dp[i][prev][0]+dp[i+1][nextval][1])%MOD;
                // }
                dp[i][prev][0]=(cumsum1[prev-1]);
            }
        }
        long result=0;
        for(int startval=1;startval<=M;startval++)
        {
            result=(result+dp[1][startval][1])%MOD;
            result=(result+dp[1][startval][0])%MOD;
        }
        return (int)result;
    }
}