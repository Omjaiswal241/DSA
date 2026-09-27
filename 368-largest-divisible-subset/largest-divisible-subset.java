class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);

        int dp[]=new int[n];
        Arrays.fill(dp,1);

        int parent[]=new int[n];
        Arrays.fill(parent,-1);

        int LIS=1;
        int LIS_idx=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0)
                {
                    if(dp[j]+1>dp[i])
                    {
                        dp[i]=dp[j]+1;
                        parent[i]=j;
                        if(LIS<dp[i])
                        {
                            LIS=dp[i];
                            LIS_idx=i;
                        }
                    }
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        while(LIS_idx!=-1)
        {
            res.add(nums[LIS_idx]);
            LIS_idx=parent[LIS_idx];
        }
        Collections.reverse(res);
        return res;
    }
}