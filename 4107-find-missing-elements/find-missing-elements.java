class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
        int low=101;
        int high=0;
        for(int i:nums)
        {
            if(i>high)
            {
                high=i;
            }
            if(i<low)
            {
                low=i;
            }
        }
        List<Integer> li=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            hm.put(nums[i],1);
        }
        for(int i=low+1;i<high;i++)
        {
            if(!hm.containsKey(i))
            {
                li.add(i);
            }
        }
        return li;
    }
}