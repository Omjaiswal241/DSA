class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        int csum=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            csum+=nums[i];
            if(hm.containsKey(csum-goal))
            {
                cnt+=hm.get(csum-goal);
            }
            hm.put(csum,hm.getOrDefault(csum,0)+1);
        }
        return cnt;
    }
}