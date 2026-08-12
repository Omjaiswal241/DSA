class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        int j=0;
        int res=0;
        for(int i=0;i<nums.length;i++)
        {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            if(hm.get(nums[i])>k)
            {
                while(j<i && hm.get(nums[i])>k)
                {
                    int freq=hm.get(nums[j])-1;
                    if(freq!=0)
                    {
                        hm.put(nums[j],freq);
                    }
                    else
                    {
                        hm.remove(nums[j]);
                    }
                    j++;
                }
            }
            res=Math.max(res,i-j+1);
        } 
        return res;  
    }
}