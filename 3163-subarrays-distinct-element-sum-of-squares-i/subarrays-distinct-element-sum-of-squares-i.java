class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size();
        int ans=0;
        for(int i=0;i<n;i++)
        {
            int cnt[]=new int[101];
            for(int j=i;j<n;j++)
            {
                cnt[nums.get(j)]++;
                int temp=0;
                for(int k=1;k<=100;k++)
                {
                    if(cnt[k]!=0)
                    {
                        temp++;
                    }
                }
                ans+=temp*temp;
            }
        }
        return ans;
    }
}