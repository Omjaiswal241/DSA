class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> li=new ArrayList<>();
        li.add(1);
        for(int i=0;i<n;i++)
        {
            li.add(nums[i]);
        }
        li.add(1);
        int dp[][]=new int[n+2][n+2];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(li,1,n,dp);
    }
    public int helper(ArrayList<Integer> li,int i,int j,int [][]dp)
    {
        if(i>j)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int coins=Integer.MIN_VALUE;
        for(int idx=i;idx<=j;idx++)
        {
            int curr=li.get(i-1)*li.get(idx)*li.get(j+1)+helper(li,i,idx-1,dp)+helper(li,idx+1,j,dp);
            coins=Math.max(coins,curr);
        }
        return dp[i][j]=coins;
    }
}