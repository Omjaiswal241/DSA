class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size();
        int ans=0;
        for(int i=0;i<n;i++)
        {
            int cnt[]=new int[101];
            int distinct=0;
            for(int j=i;j<n;j++)
            {
                if(cnt[nums.get(j)]==0)
                {
                    distinct++;
                }
                cnt[nums.get(j)]++;
                ans+=distinct*distinct;
            }
        }
        return ans;
    }
}