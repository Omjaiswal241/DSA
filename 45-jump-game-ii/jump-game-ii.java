class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--)
        {
            int k=nums[i];
            while(k>0)
            {
                int a=(i+k<n)?dp[i+k]:0;
                if(a!=Integer.MAX_VALUE)
                {
                    dp[i]=Math.min(a+1,dp[i]);
                }
                k--;
            }
        }
        return dp[0];
    }
}