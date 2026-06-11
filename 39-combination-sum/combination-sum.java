class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        helper(candidates,0,0,target,new ArrayList<>(),res);
        return res;
    }
    public void helper(int []nums,int idx,int ssf,int tar,List<Integer> li,List<List<Integer>> res)
    {
        if(ssf>tar || idx==nums.length)
        {
            return;
        }
        if(ssf==tar)
        {
            res.add(new ArrayList<>(li));
            return;
        }
        li.add(nums[idx]);
        helper(nums,idx,ssf+nums[idx],tar,li,res);
        li.remove(li.size()-1);
        helper(nums,idx+1,ssf,tar,li,res);
    }
}