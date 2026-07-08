class Solution {
    public int[] countBits(int n) {
        if(n==0)
        {
            return new int[]{0};
        }
        if(n==1)
        {
            return new int[]{0,1};
        }
        int res[]=new int[n+1];
        res[0]=0;
        res[1]=1;
        for(int i=2;i<=n;i++)
        {
            if(i%2==0)
            {
                res[i]=res[i/2];
            }
            else
            {
                res[i]=res[i/2]+1;
            }
        }
        return res;
    }
}