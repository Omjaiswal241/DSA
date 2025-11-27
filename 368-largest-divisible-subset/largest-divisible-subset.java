class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int hash[]=new int[n];
        int lastidx=0;
        int max=1;
        for(int idx=1;idx<n;idx++)
        {
            hash[idx]=idx;
            for(int j=0;j<idx;j++)
            {
                if(nums[idx]%nums[j]==0 && dp[j]+1>dp[idx])
                {
                    dp[idx]=1+dp[j];
                    hash[idx]=j;
                }
            }
            if(max<dp[idx])
            {
                max=dp[idx];
                lastidx=idx;
            }
        }
        List<Integer> li=new ArrayList<>();
        li.add(nums[lastidx]);
        while(hash[lastidx]!=lastidx)
        {
            lastidx=hash[lastidx];
            li.add(nums[lastidx]);
        }
        Collections.reverse(li);
        return li;
    }
}