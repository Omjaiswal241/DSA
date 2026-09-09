class Solution {
    public long countCommas(long n) {
        if(n<=999)
        {
            return 0;
        }
        long res=0;
        long comma=1;
        long lower=1000;
        while(lower<=n)
        {
            long upper=(lower*1000)-1;
            if(upper>n)
            {
                upper=n;
            }
            long nums=upper-lower+1;
            res+=nums*comma;
            lower=lower*1000;
            comma++;
        }
        return res;
    }
}