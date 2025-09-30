class Solution {
    public double myPow(double x, int n) {
       long N=n;
       if(N<0)
       {
        x=1/x;
        N=-N;
       } 
       if(N==0)
       {
        return 1;
       }
       double a=myPow(x,(int)(N/2));
       double b=a*a;
       if(N%2==1)
       {
        b=b*x;
       }
       return b;
    }
}