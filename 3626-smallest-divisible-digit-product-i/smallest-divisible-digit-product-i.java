class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=100;i++)
        {
            if(digit(i)%t==0)
            {
                return i;
            }
        }
        return -1;
    }
    public int digit(int n)
    {
        int f=1;
        while(n>0)
        {
            int d=n%10;
            f=f*d;
            n=n/10;
        }
        return f;
    }
}