class Solution {
    public int minElement(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            int a=helper(nums[i]);
            nums[i]=a;
        }
        int min=Integer.MAX_VALUE;
        for(int i:nums)
        {
            if(i<min)
            {
                min=i;
            }
        }
        return min;
    }
    public int helper(int n)
    {
        int sum=0;
        while(n>0)
        {
            int d=n%10;
            sum+=d;
            n=n/10;
        }
        return sum;
    }
}