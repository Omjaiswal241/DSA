class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int csum=0;
        int res=0;
        for(int i=0;i<nums.length;i++)
        {
            csum+=nums[i];
            if(hm.containsKey(csum-k))
            {
                res+=hm.get(csum-k);
            }
            hm.put(csum,hm.getOrDefault(csum,0)+1);
        }
        return res;
    }
}