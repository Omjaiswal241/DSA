class Solution {
    public long maxProduct(int[] nums) {
        long a=0,b=0;
        for(int i:nums)
        {
            int val=Math.abs(i);
            if(val>a)
            {
                b=a;
                a=val;
            }
            else if(val>b)
            {
                b=val;
            }
        }
        return 100000L*a*b;
    }
}