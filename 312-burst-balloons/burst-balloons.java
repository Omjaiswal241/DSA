class Solution {
    public int maxCoins(int[] nums) {
       int n=nums.length;
       ArrayList<Integer> li=new ArrayList<>();
       li.add(1);
       for(int i=0;i<nums.length;i++)
       {
        li.add(nums[i]);
       } 
       li.add(1);
       int dp[][]=new int[n+2][n+2];
       for(int i[]:dp)
       {
        Arrays.fill(i,-1);
       }
       return helper(1,n,li,dp);
    }
    public static int helper(int i,int j,ArrayList<Integer> li,int dp[][])
    {
        if(i>j)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int max=Integer.MIN_VALUE;
        for(int idx=i;idx<=j;idx++)
        {
            int cost=li.get(i-1)*li.get(idx)*li.get(j+1)+helper(i,idx-1,li,dp)+helper(idx+1,j,li,dp);
            max=Math.max(max,cost);
        }
        return dp[i][j]=max;
    }
}