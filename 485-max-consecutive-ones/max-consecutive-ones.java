class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       int end=0,len=0,maxlen=0;
       while(end<nums.length)
       {
        if(nums[end]==1)
        {
            len++;
            end++;
        }
        else{
            end++;
            len=0;
        }
        maxlen=Math.max(len,maxlen);
       }
       return maxlen; 
    }
}