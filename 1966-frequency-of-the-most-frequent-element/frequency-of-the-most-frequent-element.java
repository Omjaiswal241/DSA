class Solution {
    public int maxFrequency(int[] nums, int k) {
        long sum=0;
        int l=0,r,maxfreq=0;
        Arrays.sort(nums);
        long n=nums.length;
        for(r=0;r<n;r++)
        {
            sum+=nums[r];
            while(l<r && (long)nums[r]*(r-l+1)>sum+k)
            {
                sum-=nums[l];
                l++;
            }
            maxfreq=Math.max(maxfreq,(r-l+1));
        }
        return maxfreq;
    }
}