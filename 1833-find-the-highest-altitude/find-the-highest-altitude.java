class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int pre[]=new int[n];
        pre[0]=gain[0];
        for(int i=1;i<n;i++)
        {
            pre[i]=gain[i]+pre[i-1];
        }
        int max=0;
        for(int i=0;i<n;i++)
        {
            if(pre[i]>max)
            {
                max=pre[i];
            }
        }
        return max;
    }
}