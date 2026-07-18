class Solution {
    public int findGCD(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i:nums)
        {
            if(min>i)
            {
                min=i;
            }
            if(max<i)
            {
                max=i;
            }
        }
        int res=gcd(min,max);
        return res;
    }
    public int gcd(int r2,int r1)
    {
        int q=r1/r2;
        int r=r1%r2;
        while(r2!=0)
        {
            int newr1=r2;
            int newr2=r;
            if(newr2!=0)
            {
                q=newr1/newr2;
                r=newr1%newr2;
            }
            r1=newr1;
            r2=newr2;
        }
        return r1;
    }
}