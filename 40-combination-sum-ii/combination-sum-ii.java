class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        helper(candidates,0,target,new ArrayList<>(),ans);
        return ans;
    }
    public static void helper(int ar[],int start,int target,List<Integer> li,List<List<Integer>> ans)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int i=start;i<ar.length;i++)
        {
            if(i>start && ar[i]==ar[i-1])
            {
                continue;
            }
            if(ar[i]>target)
            {
                break;
            }
            li.add(ar[i]);
            helper(ar,i+1,target-ar[i],li,ans);
            li.remove(li.size()-1);
        }
    }
}