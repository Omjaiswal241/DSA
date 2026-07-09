class Solution {
    int MOD=1000000007;
    public int maximumXorProduct(long a, long b, int n) {
        long AxorX=0;
        long BxorX=0;
        for(int i=49;i>=n;i--)
        {
            boolean aset=((a>>i)&1)==1;
            boolean bset=((b>>i)&1)==1;
            if(aset)
            {
                AxorX=((AxorX)^(1L<<i));
            }
            if(bset)
            {
                BxorX=((BxorX)^(1L<<i));
            }
        }
        for(int i=n-1;i>=0;i--)
        {
            boolean aset=((a>>i)&1)==1;
            boolean bset=((b>>i)&1)==1;
            if(aset==bset)
            {
                AxorX=((AxorX)^(1L<<i));
                BxorX=((BxorX)^(1L<<i));
                continue;
            }
            if(AxorX>BxorX)
            {
                BxorX=((BxorX)^(1L<<i));
            }
            else
            {
                AxorX=((AxorX)^(1L<<i));
            }
        }
        AxorX=AxorX%MOD;
        BxorX=BxorX%MOD;
        return (int)((AxorX*BxorX)%MOD);
    }
}