class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> li=new ArrayList<>();
        li.add(nums[0]);
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>li.get(li.size()-1))
            {
                li.add(nums[i]);
            }
            else
            {
                int idx=lowerbound(li,nums[i]);
                li.set(idx,nums[i]);
            }
        }
        return li.size();
    }
    public static int lowerbound(ArrayList<Integer> li,int num)
    {
        int low=0;
        int high=li.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(li.get(mid)<num)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return low;
    }
}