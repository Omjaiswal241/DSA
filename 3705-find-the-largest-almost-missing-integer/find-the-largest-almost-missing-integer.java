class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<=n-k;i++)
        {
            HashSet<Integer> hs=new HashSet<>();
            for(int j=i;j<i+k;j++)
            {
                hs.add(nums[j]);
            }
            for(int x:hs)
            {
                hm.put(x,hm.getOrDefault(x,0)+1);
            }
        }
        int ans=-1;
        for(int key:hm.keySet())
        {
            int freq=hm.get(key);
            if(freq==1 && key>ans)
            {
                ans=key;
            }
        }
        return ans;
    }
}