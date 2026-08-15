class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int resxor=0;
        boolean allzero=true;
        for(int num:nums)
        {
            resxor^=num;
            if(num!=0)
            {
                allzero=false;
            }
        }
        if(allzero)
        {
            return 0;
        }
        return resxor==0?n-1:n;
    }
}