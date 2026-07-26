class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--)
        {
            int jumps=nums[i];
            while(jumps>0)
            {
                int pos=(jumps+i<=n-1)?dp[jumps+i]:0;
                if(pos!=Integer.MAX_VALUE)
                {
                dp[i]=Math.min(dp[i],pos+1);
                }
                jumps--;
            }
        } 
        return dp[0];
    }
}