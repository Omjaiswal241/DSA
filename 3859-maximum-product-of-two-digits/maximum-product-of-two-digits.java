class Solution {
    public int maxProduct(int n) {
        int max=0;
        int secmax=0;
        while(n>0)
        {
            int d=n%10;
            if(d>max)
            {
                secmax=max;
                max=d;
            }
            else if(d>secmax)
            {
                secmax=d;
            }
            n=n/10;
        }
        return max*secmax;
    }
}