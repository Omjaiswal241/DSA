class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> li=new ArrayList<List<Integer>>();
       getperm(nums,0,li);
       return li; 
    }
    void getperm(int[] nums,int idx,List<List<Integer>> li)
    {
        if(idx==nums.length)
        {
            List<Integer> temp=new ArrayList<>();
            for(int i:nums)
            {
                temp.add(i);
            }
            li.add(temp);
            return;
        }
        for(int i=idx;i<nums.length;i++)
        {
            swap(nums,i,idx);
            getperm(nums,idx+1,li);
            swap(nums,i,idx);
        }
    }
    void swap(int []nums,int a,int b)
    {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}