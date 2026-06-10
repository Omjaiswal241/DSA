class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(n<=3)
        {
            return 0;
        }
        int a=(n>4)?nums[n-4]-nums[0]:Integer.MAX_VALUE;
        int b=(n>3)?nums[n-1]-nums[3]:Integer.MAX_VALUE;
        int c=(n>2)?nums[n-3]-nums[1]:0;
        int d=(n>1)?nums[n-2]-nums[2]:0;
        return Math.min(a,Math.min(b,Math.min(c,d)));
    }
}