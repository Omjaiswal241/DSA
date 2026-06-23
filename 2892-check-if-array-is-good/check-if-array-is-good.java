class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int max=nums[n-1];
        if(max+1!=n)
        {
            return false;
        }
        for(int i=0;i<n;i++)
        {
            if(i<n-2)
            {
                if(nums[i]!=i+1)
                {
                    return false;
                }
            }
            else if(nums[i]!=max)
            {
                return false;
            }
        }
        return true;
    }
}