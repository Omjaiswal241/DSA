class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,0,target,new ArrayList<>());
        return res;
    }
    public void helper(int []candidates,int start,int target,List<Integer> li)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(li));
            return;
        }
        if(start==candidates.length || target<0)
        {
            return;
        }
        for(int i=start;i<candidates.length;i++)
        {
            if(i!=start && candidates[i-1]==candidates[i])
            {
                continue;
            }
            if(target-candidates[i]<0)
            {
                break;
            }
            li.add(candidates[i]);
            helper(candidates,i+1,target-candidates[i],li);
            li.remove(li.size()-1);
        }
    }
}