class Solution {
    public boolean kLengthApart(int[] nums, int k) {
    List<Integer> li=new ArrayList<>();
    for(int i=0;i<nums.length;i++)
    {
        if(nums[i]==1)
        {
            li.add(i);
        }
    }
    return check(li,k);
    }
    public static boolean check(List<Integer> li,int k)
    {
        for(int i=1;i<li.size();i++)
        {
            if(li.get(i)-li.get(i-1)-1<k)
            {
                return false;
            }
        }
        return true;
    }
}