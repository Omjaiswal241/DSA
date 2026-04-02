class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums,0);
        return res;
    }
    public void helper(int []nums,int idx)
    {
        if(idx==nums.length)
        {
            List<Integer> li=new ArrayList<>();
            for(int i:nums)
            {
                li.add(i);
            }
            res.add(li);
            return;
        }
        for(int i=idx;i<nums.length;i++)
        {
            swap(nums,i,idx);
            helper(nums,idx+1);
            swap(nums,i,idx);
        }
    }
    public void swap(int nums[],int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}