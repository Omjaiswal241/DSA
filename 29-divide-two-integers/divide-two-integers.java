class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==divisor)
        {
            return 1;
        }
        if(divisor==0)
        {
            return Integer.MAX_VALUE;
        }
        if(dividend==Integer.MIN_VALUE && divisor==-1)
        {
            return Integer.MAX_VALUE;
        }
        boolean sign=true;
        if(dividend<0 && divisor>0)
        {
            sign=false; 
        }
        else if(dividend>0 && divisor<0)
        {
            sign=false;
        }
        long ans=0;
        long n=Math.abs((long)dividend);
        long d=Math.abs((long)divisor);
        while(n>=d)
        {
            int cnt=0;
            while(n>=(d*(1L<<(cnt+1))))
            {
                cnt++;
            }
            ans+=(1L<<cnt);
            n-=(d*(1L<<cnt));
        }
        return (sign)?(int)ans:-(int)ans;
    }
}