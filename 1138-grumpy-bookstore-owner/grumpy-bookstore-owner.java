class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maxsum=0;
        for(int i=0;i<=grumpy.length-minutes;i++)
        {
            int sum=0;
            for(int j=i;j<i+minutes;j++)
            {
                if(grumpy[j]==1)
                {
                    sum+=customers[j];
                }
            }
            maxsum=Math.max(maxsum,sum);
        }
        int res=0;
        for(int i=0;i<grumpy.length;i++)
        {
            if(grumpy[i]==0)
            {
                res+=customers[i];
            }
        }
        return res+maxsum;
    }
}