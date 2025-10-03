class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        int j=nums.length-1;
        while(i>=0 && nums[i]>=nums[i+1])
        {
            i--;
        }
        if(i>=0)
        {
            while(j>=0 && nums[j]<=nums[i])
            {
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }
    public void swap(int nums[],int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int []nums,int start)
    {
        int end=nums.length-1;
        while(start<=end)
        {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}