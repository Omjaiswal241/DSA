class Solution {
    public int largestInteger(int n, int s) {
        int lim=(int)Math.pow(10,n);
        for(int i=lim-1;i>=0;i--)
        {
            if(sum(i)==s)
            {
                return i;
            }
        }
        return -1;
    }
    public int sum(int i)
    {
        int sum=0;
        while(i>0)
        {
            int d=i%10;
            sum+=d;
            i=i/10;
        }
        return sum;
    }
}