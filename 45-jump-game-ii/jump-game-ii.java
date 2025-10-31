class Solution {
    public int jump(int[] nums) {
        return jumpT(nums);
    }
    public static int jumpT(int []nums)
    {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i=n-1;i>=0;i--)
        {
            if(i==n-1)
            {
                dp[i]=0;
            }
            else
            {
                int idx=nums[i];
                while(idx>0)
                {
                    if(idx+i<n)
                    {
                        dp[i]=Math.min(dp[idx+i],dp[i]);
                    }
                        idx--;
                        if(idx==0 && dp[i]!=Integer.MAX_VALUE)
                        {
                            dp[i]++;
                        }
                    }
                }
            }
            return dp[0];
        }
    }