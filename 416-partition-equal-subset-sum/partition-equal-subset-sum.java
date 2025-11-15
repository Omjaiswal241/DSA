class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
        }
        if(sum%2==1)
        {
            return false;
        }
        int target=sum/2;
        if(target(nums,target))
        {
            return true;
        }
        return false;
    }
    public static boolean target(int nums[],int target)
    {
        boolean dp[][]=new boolean[nums.length+1][target+1];
        for(int i=0;i<=nums.length;i++)
        {
            for(int j=0;j<=target;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j]=true;
                }
                else if(i==0)
                {
                    dp[i][j]=false;
                }
                else if(j==0)
                {
                    dp[i][j]=true;
                }
                else
                {
                    boolean inc=(j-nums[i-1]>=0)?dp[i-1][j-nums[i-1]]:false;
                    boolean exc=dp[i-1][j];
                    dp[i][j]=inc||exc;
                }
            }
            if(dp[i][target]==true)
            {
                return true;
            }
        }
        return false;
    }
}