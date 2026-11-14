class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int temp[]=new int[n];
        temp[0]=nums.get(0);
        for(int i=1;i<n;i++)
        {
            temp[i]=temp[i-1]+nums.get(i);
        }
        int ans=-1;
        boolean getfirst_ans=false;
        for(int i=0;i<n;i++)
        {
            for(int j=i+l-1;j<=Math.min(i+r-1,n-1);j++)
            {
                int prev=(i>0)?temp[i-1]:0;
                if((temp[j]-prev)>0)
                {
                    if(getfirst_ans==false)
                    {
                        ans=(temp[j]-prev);
                        getfirst_ans=true;
                    }
                    else
                    {
                        if((temp[j]-prev)<ans)
                        {
                            ans=(temp[j]-prev);
                        }
                    }
                }
            }
        }
        return ans;
    }
}