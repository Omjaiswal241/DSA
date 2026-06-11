class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        helper(candidates,0,target,0,new ArrayList<>(),res);
        return res;
    }
    public void helper(int nums[],int idx,int tar,int ssf,List<Integer> li,List<List<Integer>> res)
    {
        if(ssf==tar)
        {
            res.add(new ArrayList<>(li));
            return;
        }
        for(int i=idx;i<nums.length;i++)
        {
            if(i!=idx && nums[i]==nums[i-1])
            {
                continue;
            }
            if(ssf+nums[i]>tar)
            {
                break;
            }
            li.add(nums[i]);
            helper(nums,i+1,tar,ssf+nums[i],li,res);
            li.remove(li.size()-1);
        }
    }
}