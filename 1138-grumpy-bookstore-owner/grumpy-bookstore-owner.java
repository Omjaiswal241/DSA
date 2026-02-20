class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    int a=0,b=0,maxsum=0;
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
        if(sum>maxsum)
        {
            maxsum=sum;
            a=i;
            b=i+minutes-1;
        }
    }
    int res=0;
    for(int i=0;i<a;i++)
    {
        if(grumpy[i]==0)
        {
            res+=customers[i];
        }
    }
    for(int i=a;i<=b;i++)
    {
        res+=customers[i];
    }
    for(int i=b+1;i<customers.length;i++)
    {
        if(grumpy[i]==0)
        {
            res+=customers[i];
        }
    }
    return res;
    }
}