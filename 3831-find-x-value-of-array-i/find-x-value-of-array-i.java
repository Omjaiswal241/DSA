class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n=nums.length;
        long res[]=new long[k];
        long prev[]=new long[k];
        for(int i=0;i<n;i++)
        {
            long curr[]=new long[k];
            int curr_reminder=nums[i]%k;
            curr[curr_reminder]++;
            for(int oldrem=0;oldrem<=k-1;oldrem++)
            {
                int newrem=(int)((long)oldrem*nums[i]%k)%k;
                curr[newrem]+=prev[oldrem];
            }
            prev=curr;
            for(int x=0;x<=k-1;x++)
            {
                res[x]+=prev[x];
            }
        }
        return res;
    }
}