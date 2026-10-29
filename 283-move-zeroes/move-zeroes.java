class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int i=0,k=0;
        while(k<n)
        {
            if(nums[k]!=0)
            {
                int temp=nums[k];
                nums[k]=nums[i];
                nums[i]=temp;
                k++;
                i++;
            }
            else
            {
                k++;
            }
        }
    }
}