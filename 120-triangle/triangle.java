class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[]=new int[n];
        int temp[]=new int[n];
        for(int i=0;i<triangle.get(n-1).size();i++)
        {
            dp[i]=triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--)
        {
            for(int j=i;j>=0;j--)
            {
            temp[j]=triangle.get(i).get(j)+Math.min(dp[j+1],dp[j]);
            }
            for(int j=0;j<n;j++)
            {
                dp[j]=temp[j];
            }
        }
        return dp[0];
    }
}