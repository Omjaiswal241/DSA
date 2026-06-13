class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(li.size()==0)
            {
                li.add(nums[i]);
            }
            else
            {
                int idx=findidx(li,nums[i]);
                if(idx<li.size())
                {
                    li.remove(idx);
                }
                li.add(idx,nums[i]);
            }
        }
        return li.size();
    }
    public int findidx(List<Integer> li,int k)
    {
        int pos=-1;
        for(int i=0;i<li.size();i++)
        {
            if(li.get(i)>=k)
            {
                return i;
            }
        }
        return li.size();
    }
}