class Solution {
    public int missingInteger(int[] nums) {
        boolean temp[]=new boolean[51];
        for(int i:nums)
        {
            temp[i]=true;
        }
        int sum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]-1==nums[i-1])
            {
                sum+=nums[i];
            }
            else
            {
                break;
            }
        }
        int res=sum;
        for(int i=sum;i<51;i++)
        {
            if(temp[i]==true)
            {
                res++;
            }
            else
            {
                break;
            }
        }
        return res;
    }
}