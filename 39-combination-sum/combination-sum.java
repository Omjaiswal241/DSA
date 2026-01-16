class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates,target,0,0,new ArrayList<>());
        return res;
    }
    public void helper(int [] candidates,int target,int idx,int ssf,List<Integer> li)
    {
        if(idx==candidates.length || ssf>target)
        {
            return;
        }
        if(ssf==target)
        {
            res.add(new ArrayList<>(li));
            return;
        }
        li.add(candidates[idx]);
        helper(candidates,target,idx,ssf+candidates[idx],li);
        li.remove(li.size()-1);
        helper(candidates,target,idx+1,ssf,li);
    }
}