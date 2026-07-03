class Solution {
    public int subtractProductAndSum(int n) {
       long p=1,s=0;
       while(n>0)
       {
        int d=n%10;
        p=p*d;
        s+=d;
        n=n/10;
       }
       return (int)(p-s);
    }
}