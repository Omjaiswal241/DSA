class Solution {
    public boolean check(int[] nums) {
        int count=0,i=0;
        while(i<nums.length-1)
        {
            if(nums[i]>nums[i+1])
            {
                count++;
            }
            i++;
        }
        if(nums[nums.length-1]>nums[0])
        {
            count++;
        }
        if(count>1)
        {
            return false;
        }
        else{
        return true;
        }
    }
}