class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,0,k,dp);
    }
    public int helper(int ar[],int idx,int k,int dp[])
    {
        if(idx==ar.length)
        {
            return 0;
        }
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        int final_ans=Integer.MIN_VALUE;
        int ans=Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
        for(int j=idx;j<Math.min(ar.length,idx+k);j++)
        {
            max=Math.max(max,ar[j]);
            int len=j-idx+1;
            ans=(max*len)+helper(ar,j+1,k,dp);
            final_ans=Math.max(final_ans,ans);
        }
        return dp[idx]=final_ans;
    }
}