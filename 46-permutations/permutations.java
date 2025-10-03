class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> li=new ArrayList<List<Integer>>();
        getperm(nums,0,li);
        return li;
    }
    public static void getperm(int []nums,int idx,List<List<Integer>> li)
    {
        if(idx==nums.length)
        {
            List<Integer> temp=new ArrayList<>();
            for(int i:nums)
            {
                temp.add(i);
            }
            li.add(temp);
        }
        for(int i=idx;i<nums.length;i++)
        {
            swap(nums,i,idx);
            getperm(nums,idx+1,li);
            swap(nums,i,idx);
        }
    }
    public static void swap(int ar[],int i,int j)
    {
        int temp=ar[i];
        ar[i]=ar[j];
        ar[j]=temp;
    }
}