class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0,i=0;
        int maxsum=Integer.MIN_VALUE;
        while(i<nums.length)
        {
            sum+=nums[i];
            maxsum=Math.max(sum,maxsum);
            if(sum<0)
            {
                sum=0;
            }
            i++;
        }
        return maxsum;
    }
}