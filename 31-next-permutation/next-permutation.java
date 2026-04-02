class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int point=-1;
        for(int i=n-1;i>0;i--)
        {
            if(nums[i]>nums[i-1])
            {
                point=i-1;
                break;
            }
        }
        if(point!=-1)
        {
        for(int i=n-1;i>point;i--)
        {
            if(nums[i]>nums[point])
            {
                swap(nums,point,i);
                break;
            }
        }
        }
        reverse(nums,point+1);
    }
    public void reverse(int nums[],int g)
    {
        int low=g;
        int high=nums.length-1;
        while(low<high)
        {
            int temp=nums[low];
            nums[low]=nums[high];
            nums[high]=temp;
            low++;
            high--;
        }
    }
    public void swap(int nums[],int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}