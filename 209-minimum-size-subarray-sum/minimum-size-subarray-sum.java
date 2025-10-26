class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start=0;
        int sum=0,min=Integer.MAX_VALUE;
        for(int end=0;end<nums.length;end++)
        {
            sum+=nums[end];
            while(sum>=target)
            {
                int len=end-start+1;
                min=Math.min(len,min);
                sum-=nums[start];
                start++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}