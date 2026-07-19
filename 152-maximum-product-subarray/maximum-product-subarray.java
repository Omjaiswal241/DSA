class Solution {
    public int maxProduct(int[] nums) {
        int pre=1,suff=1;
        int n=nums.length;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            pre=pre*nums[i];
            suff=suff*nums[n-i-1];
            res=Math.max(res,Math.max(pre,suff));
            if(pre==0)
            {
                pre=1;
            }
            if(suff==0)
            {
                suff=1;
            }
        }
        return res;
    }
}