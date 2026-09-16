class Solution {
    int n;
    int dp[];
    int prev[];
    int MOD=1000000007;
    public int distinctSubseqII(String s) {
        n=s.length();
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        prev=new int[n+1];
        int lastseen[]=new int[26];
        for(int i=1;i<=n;i++)
        {
            int idx=s.charAt(i-1)-'a';
            prev[i]=lastseen[idx];
            lastseen[idx]=i;
        }
        return (solve(n)-1+MOD)%MOD;
    }
    public int solve(int n)
    {
        if(n==0)
        {
            return 1;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        int total=(2*solve(n-1))%MOD;
        if(prev[n]!=0)
        {
            int duplicates=solve(prev[n]-1);
            total=(total-duplicates+MOD)%MOD;
        }
        return dp[n]=total;
    }
}