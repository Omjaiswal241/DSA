class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,0,k,dp);
    }
    public static int helper(int ar[],int idx,int k,int dp[])
    {
        int n=ar.length;
        if(idx==n)
        {
            return 0;
        }
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        int maxsum=Integer.MIN_VALUE;
        int len=0;
        int max=Integer.MIN_VALUE;
        for(int i=idx;i<Math.min(n,idx+k);i++)
        {
            len++;
            max=Math.max(ar[i],max);
            int sum=(len*max)+helper(ar,i+1,k,dp);
            maxsum=Math.max(sum,maxsum);
        }
        return dp[idx]=maxsum;
    }
}