class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,target,0,0,new ArrayList<>());
        return res;
    }
    public void helper(int ar[],int target,int idx,int ssf,List<Integer> li)
    {
        if(ssf>target)
        {
            return;
        }
        if(ssf==target)
        {
            res.add(new ArrayList<>(li));
            return;
        }
        for(int i=idx;i<ar.length;i++)
        {
            if(i>idx && ar[i]==ar[i-1])
            {
                continue;
            }
            li.add(ar[i]);
            helper(ar,target,i+1,ssf+ar[i],li);
            li.remove(li.size()-1);
        }
    }
}