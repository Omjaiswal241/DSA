class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        int pre[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(nums[i]%2==1)
            {
                pre[i]=i>0?pre[i-1]+1:1;
            }
            else
            {
                pre[i]=i>0?pre[i-1]:0;
            }
        }
        int j=0;
        int cnt=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        while(j<n)
        {
            if(hm.containsKey(pre[j]-k))
            {
                cnt+=hm.get(pre[j]-k);
            }
            hm.put(pre[j],hm.getOrDefault(pre[j],0)+1);
            j++;
        }
        return cnt;
    }
}