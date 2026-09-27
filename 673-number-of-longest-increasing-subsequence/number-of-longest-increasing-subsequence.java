class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int cnt[]=new int[n];
        Arrays.fill(cnt,1);
        int LIS=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                {
                    if(dp[j]+1>dp[i])
                    {
                        dp[i]=dp[j]+1;
                        cnt[i]=cnt[j];
                    }
                    else if(dp[j]+1==dp[i])
                    {
                        cnt[i]+=cnt[j];
                    }
                    if(LIS<dp[i])
                    {
                        LIS=dp[i];
                    }
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(dp[i]==LIS)
            {
                ans+=cnt[i];
            }
        }
        return ans;
    }
}