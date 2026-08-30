class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int min_idx=0;
        int max_idx=0;
        for(int i=1;i<n;i++)
        {
            if(nums[i]>nums[max_idx])
            {
                max_idx=i;
            }
            if(nums[i]<nums[min_idx])
            {
                min_idx=i;
            }
        }
        int from_front=min_idx>=max_idx?(min_idx+1):(max_idx+1);
        int from_back=min_idx<max_idx?(n-min_idx):(n-max_idx);
        int both_side1=min_idx+1+(n-max_idx);
        int both_side2=max_idx+1+(n-min_idx);
        return Math.min(from_front,Math.min(from_back,Math.min(both_side1,both_side2)));
    }
}