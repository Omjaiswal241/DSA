class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        int limit=(int)Math.pow(2,n);
        for(int num=0;num<limit;num++)
        {
            List<Integer> li=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                if((num&(1<<i))!=0)
                {
                    li.add(nums[i]);
                }
            }
            res.add(new ArrayList<>(li));
        }
        return res;
    }
}