class Solution {
    public int missingInteger(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums)
        {
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int sum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]-1==nums[i-1])
            {
                sum+=nums[i];
            }
            else
            {
                break;
            }
        }
        int tar=sum;
        while(hm.containsKey(tar))
        {
            tar++;
        }
        return tar;
    }
}