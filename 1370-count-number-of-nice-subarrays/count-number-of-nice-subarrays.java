class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        int j=0;
        int cnt=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        int csum=0;
        hm.put(0,1);
        while(j<n)
        {
            if(nums[j]%2==1)
            {
                csum+=1;
            }
            if(hm.containsKey(csum-k))
            {
                cnt+=hm.get(csum-k);
            }
            hm.put(csum,hm.getOrDefault(csum,0)+1);
            j++;
        }
        return cnt;
    }
}