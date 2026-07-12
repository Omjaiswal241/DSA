class Solution {
    public int[] singleNumber(int[] nums) {
        int sum=0;
        for(int num:nums)
        {
            sum^=num;
        }
        int i=0;
        while((sum&(1<<i))==0)
        {
            i++;
        }
        int a=0;
        int b=0;
        for(int num:nums)
        {
            if((num&(1<<i))!=0)
            {
                a^=num;
            }
            else if((num&(1<<i))==0)
            {
                b^=num;
            }
        }
        return new int[]{a,b};
    }
}