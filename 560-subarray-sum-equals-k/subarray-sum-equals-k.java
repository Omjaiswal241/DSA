class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int curr=0,res=0;
        for(int i=0;i<nums.length;i++)
        {
            curr+=nums[i];
            res+=hm.getOrDefault((curr-k),0);
            hm.put(curr,hm.getOrDefault(curr,0)+1);
        }
        return res; 
    }
}