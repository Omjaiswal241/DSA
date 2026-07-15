class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        int max=0;
        for(int num:nums)
        {
            hs.add(num);
            if(max<num)
            {
                max=num;
            }
        }
        for(int i=1;i<=max;i++)
        {
            if(!hs.contains(i))
            {
                return i;
            }
        }
        return max<0?1:max+1;
    }
}