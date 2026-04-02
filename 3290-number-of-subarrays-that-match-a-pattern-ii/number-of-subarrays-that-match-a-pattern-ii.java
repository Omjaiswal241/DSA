class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n=nums.length;
        int m=pattern.length;
        int temp[]=new int[n-1];
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]<nums[i+1])
            {
                temp[i]=1;
            }
            else if(nums[i]==nums[i+1])
            {
                temp[i]=0;
            }
            else{
                temp[i]=-1;
            }
        }
        int lps[]=lps(pattern);
        int s=temp.length;
        int count=0;
        int i=0,j=0;
        while(i<s)
        {
            if(temp[i]==pattern[j])
            {
                i++;
                j++;
            }
            if(j==m)
            {
                count++;
                j=lps[j-1];
            }
            else if(i<s && temp[i]!=pattern[j])
            {
                if(j!=0)
                {
                    j=lps[j-1];
                }
                else
                {
                    i++;
                }
            }
        }
        return count;
    }
    public int[] lps(int pattern[])
    {
        int n=pattern.length;
        int lps[]=new int[pattern.length];
        int i=1,len=0;
        while(i<n)
        {
            if(pattern[len]==pattern[i])
            {
                len++;
                lps[i]=len;
                i++;
            }
            else
            {
                if(len!=0)
                {
                    len=lps[len-1];
                }
                else
                {
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
}