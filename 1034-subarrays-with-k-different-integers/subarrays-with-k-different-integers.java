class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums,k)-count(nums,k-1);
    }
    public int count(int nums[],int k)
    {
        int n=nums.length;
        int i=0,j=0,cnt=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        while(j<n)
        {
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            while(hm.size()>k)
            {
                hm.put(nums[i],hm.get(nums[i])-1);
                if(hm.get(nums[i])==0)
                {
                    hm.remove(nums[i]);
                }
                i++;
            }
            cnt+=j-i+1;
            j++;
        }
        return cnt;
    }
}