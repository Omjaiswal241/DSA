class Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int k=0;k<=31;k++)
        {
            int temp=1<<k;
            int cntzeros=0,cntones=0;
            for(int num:nums)
            {
                if((temp&num)==0)
                {
                    cntzeros++;
                }
                else
                {
                    cntones++;
                }
            }
            if(cntones%3==1)
            {
                res=(res|temp);
            }
        }
        return res;
    }
}