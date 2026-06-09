class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int  min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i:nums)
        {
            if(i>max)
            {
                max=i;
            }
            if(i<min)
            {
                min=i;
            }
        }
        long diff=max-min;
        long res=(long)k*diff;
        return res;
    }
}