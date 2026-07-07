class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long res=0;
        int p=0;
        while(n>0)
        {
            long d=n%10;
            if(d!=0)
            {
                res=(long)(d*Math.pow(10,p))+res;
                p++;
            }
            sum+=d;
            n=n/10;
        }
        return sum*res;
    }
}