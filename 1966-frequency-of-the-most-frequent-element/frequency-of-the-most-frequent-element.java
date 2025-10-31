class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0;
        int maxfreq=Integer.MIN_VALUE;
        int n=nums.length;
        long sum=0;
        for(int r=0;r<n;r++)
        {
            sum+=nums[r];
            while(l<r && (sum+k)<((long)nums[r]*(r-l+1)))
            {
                sum-=nums[l];
                l++;
            }
            maxfreq=Math.max(maxfreq,(r-l+1));
        }
        return maxfreq;
    }
}