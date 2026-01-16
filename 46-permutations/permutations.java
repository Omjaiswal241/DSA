class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums,0);
        return res;
    }
    public void helper(int [] nums,int level)
    {
        if(level==nums.length)
        {
            List<Integer> temp=new ArrayList<>();
            for(int i:nums)
            {
                temp.add(i);
            }
            res.add(temp);
            return;
        }
        for(int i=level;i<nums.length;i++)
        {
        swap(nums,i,level);
        helper(nums,level+1);
        swap(nums,i,level);
        }
    }
    public void swap(int nums[],int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}