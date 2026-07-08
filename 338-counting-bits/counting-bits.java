class Solution {
    public int[] countBits(int n) {
        int res[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            res[i]=cnt(i);
        }
        return res;
    }
    public int cnt(int n)
    {
        int cnt=0;
        while(n>0)
        {
            if((n&1)==1)
            {
                cnt++;
            }
            n=n>>1;
        }
        return cnt;
    }
}