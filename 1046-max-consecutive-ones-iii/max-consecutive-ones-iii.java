class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxlen=0;
        int n=nums.length;
        int zeros=0;
        int j=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                zeros++;
            }
            if(zeros>k)
            {
                zeros=(nums[j]==0)?zeros-1:zeros;
                j++;
            }
            if(zeros<=k)
            {
                maxlen=Math.max(maxlen,i-j+1);
            }
        }
        return maxlen;
    }
}