class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        for(int i=n-2;i>=0;i--)
        {
            int a=nums[i];
            int jumps=Integer.MAX_VALUE;
            while(a>0)
            {
                if(i+a<n)
                {
                    jumps=Math.min(dp[i+a],jumps);
                }
                a--;
            }
            if(jumps!=Integer.MAX_VALUE)
            {
                dp[i]=jumps+1;
            }
            else
            {
                dp[i]=Integer.MAX_VALUE;
            }
        }
        return dp[0];
    }
}