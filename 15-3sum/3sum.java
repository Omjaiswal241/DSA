class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> res=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n-2;i++)
        {
            int j=i+1,k=n-1;
            while(j<k)
            {
                long sum=nums[i];
                sum+=nums[j];
                sum+=nums[k];
                if(sum==0)
                {
                    List<Integer> li=new ArrayList<>();
                    li.add(nums[i]);
                    li.add(nums[j]);
                    li.add(nums[k]);
                    res.add(new ArrayList<>(li));
                    j++;
                }
                else if(sum>0)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
        }
        return new ArrayList<>(res);
    }
}