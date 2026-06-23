class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> li=new ArrayList<>();
        int s=nums.length;
        for(int i=s-1;i>=0;i--)
        {
            int n=nums[i];
            while(n>0)
            {
                int d=n%10;
                li.addFirst(d);
                n=n/10;
            }
        }
        int res[]=new int[li.size()];
        for(int i=0;i<li.size();i++)
        {
            res[i]=li.get(i);
        }
        return res;
    }
}