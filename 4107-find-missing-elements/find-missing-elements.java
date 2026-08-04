class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int low=nums[0];
        int high=nums[n-1];
        List<Integer> li=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=1;i<n-1;i++)
        {
            hm.put(nums[i],1);
        }
        for(int i=low+1;i<high;i++)
        {
            if(!hm.containsKey(i))
            {
                li.add(i);
            }
        }
        return li;
    }
}