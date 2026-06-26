class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        long res=0;
        long validleftpoints=0;
        int cumsum=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        for(int j=0;j<nums.length;j++)
        {
            if(nums[j]==target)
            {
                validleftpoints+=hm.getOrDefault(cumsum,0);
                cumsum++;
            }
            else
            {
                cumsum--;
                validleftpoints-=hm.getOrDefault(cumsum,0);
            }
            hm.put(cumsum,hm.getOrDefault(cumsum,0)+1);
            res+=validleftpoints;
        }
        return res;
    }
}