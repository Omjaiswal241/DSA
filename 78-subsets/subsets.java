class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> res=new ArrayList<>();
       helper(nums,0,new ArrayList<>(),res); 
       return res;
    }
    void helper(int nums[],int idx,List<Integer> li,List<List<Integer>> res)
    {
        if(idx==nums.length)
        {
            res.add(new ArrayList<>(li));
            return;
        }
        helper(nums,idx+1,li,res);
        li.add(nums[idx]);
        helper(nums,idx+1,li,res);
        li.remove(li.size()-1);
    }
}