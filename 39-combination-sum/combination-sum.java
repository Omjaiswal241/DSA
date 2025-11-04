class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     List<List<Integer>> ans=new ArrayList<>();
     helper(candidates,target,0,0,new ArrayList<>(),ans);
     return ans;
    }
    public static void helper(int []ar,int target,int idx,int asf,List<Integer> li,List<List<Integer>> ans)
    {
        if(asf>target || idx==ar.length)
        {
            return;
        }
        if(asf==target)
        {
            ans.add(new ArrayList<>(li));
            return;
        }
        li.add(ar[idx]);
        helper(ar,target,idx,asf+ar[idx],li,ans);
        li.remove(li.size()-1);
        helper(ar,target,idx+1,asf,li,ans);
    }
}