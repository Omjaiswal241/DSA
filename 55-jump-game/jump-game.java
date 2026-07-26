class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i=0;i<n-1;i++)
        {
            if(i+nums[i]>max)
            {
                max=i+nums[i];
            }
            else if(max==i)
            {
                return false;
            }
            else if(max>=n-1)
            {
                return true;
            }
        }
        return true;
    }
}