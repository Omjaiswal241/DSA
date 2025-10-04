class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        hs.put(0,1);
        int curr=0,res=0;
        for(int i:nums)
        {
            curr+=i;
            res+=hs.getOrDefault((curr-k),0);
            hs.put(curr,hs.getOrDefault(curr,0)+1);
        }
        return res;
    }
}