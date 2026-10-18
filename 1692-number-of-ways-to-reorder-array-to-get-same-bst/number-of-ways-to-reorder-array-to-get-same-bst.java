class Solution {
    long MOD=1000000007;
    long dp[][];
    public int numOfWays(int[] nums) {
        int n=nums.length;
        dp=new long[n+1][];
        for(int i=0;i<=n;i++)
        {
            dp[i]=new long[i+1];
            Arrays.fill(dp[i],1);
            for(int j=1;j<i;j++)
            {
                dp[i][j]=(dp[i-1][j]+dp[i-1][j-1])%MOD;
            }
        }
        List<Integer> li=new ArrayList<>();
        for(int i:nums)
        {
            li.add(i);
        }
        return (int)((solve(li)-1+MOD)%MOD);
    }
    public long solve(List<Integer> li)
    {
        int n=li.size();
        if(n<3)
        {
            return 1;
        }
        int root=li.get(0);
        List<Integer> left=new ArrayList<>();
        List<Integer> right=new ArrayList<>();
        for(int i=1;i<li.size();i++)
        {
            int node=li.get(i);
            if(node<root)
            {
                left.add(node);
            }
            else
            {
                right.add(node);
            }
        }
        long x=solve(left)%MOD;
        long y=solve(right)%MOD;
        return (((x*y)%MOD)*dp[n-1][left.size()])%MOD;
    }
}