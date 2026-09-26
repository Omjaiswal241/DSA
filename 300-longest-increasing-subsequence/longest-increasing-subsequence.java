class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        List<Integer> li=new ArrayList<>();
        for(int i:nums)
        {
            if(li.size()==0)
            {
                li.add(i);
            }
            if(li.get(li.size()-1)<i)
            {
                li.add(i);
            }
            else
            {
                int j=0;
                while(li.get(j)<i)
                {
                    j++;
                }
                li.set(j,i);
            }
        }
        return li.size();
    }
}