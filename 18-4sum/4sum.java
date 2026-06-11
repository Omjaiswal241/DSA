class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        HashSet<String> hs=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n-3;i++)
        {
            for(int j=i+1;j<n-2;j++)
            {
                int l=j+1,h=n-1;
                while(l<h)
                {
                    long sum=nums[i];
                    sum+=nums[j];
                    sum+=nums[l];
                    sum+=nums[h];
                    if(sum>target)
                    {
                        h--;
                    }
                    else if(sum<target)
                    {
                        l++;
                    }
                    else
                    {
                        StringBuilder sb=new StringBuilder();
                        sb.append(nums[i]);
                        sb.append(nums[j]);
                        sb.append(nums[l]);
                        sb.append(nums[h]);
                        String s=sb.toString();
                        if(!hs.contains(s))
                        {
                            hs.add(s);
                            res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[h]));
                        }
                        l++;
                        h--;
                    }
                }
            }
        }
        return res;
    }
}