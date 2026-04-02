class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<n-3;i++)
        {
            for(int j=i+1;j<n-2;j++)
            {
                int low=j+1;
                int high=n-1;
                while(low<high)
                {
                    long sum=nums[i];
                    sum+=nums[j];
                    sum+=nums[low];
                    sum+=nums[high];
                    if(sum==target)
                    {
                        StringBuilder sb=new StringBuilder();
                        sb.append(nums[i]);
                        sb.append(nums[j]);
                        sb.append(nums[low]);
                        sb.append(nums[high]);
                        String s=sb.toString();
                        if(!hs.contains(s))
                        {
                            hs.add(s);
                            res.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        }
                        low++;
                        high--;
                    }
                    else if(sum>target)
                    {
                        high--;
                    }
                    else
                    {
                        low++;
                    }
                }
            }
        }
        return res;
    }
}