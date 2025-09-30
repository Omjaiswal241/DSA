class Solution {
    static long MOD=1_000_000_007;
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        long first=(pow(5,even))%MOD;
        long second=(pow(4,odd))%MOD;
        return (int)((first*second)%MOD);
    }
    public long pow(long x,long n)
    {
        if(n==0)
        {
            return 1;
        }
        long a=pow(x,n/2);
        long b=(a*a)%MOD;
        if(n%2==1)
        {
            b=(b*x)%MOD;
        }
        return b;
    }
}