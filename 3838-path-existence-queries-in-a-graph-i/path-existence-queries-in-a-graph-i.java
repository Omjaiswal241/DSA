class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int m=queries.length;
        boolean res[]=new boolean[m];
        int bad[]=new int[n];
        int pre[]=new int[n];
        for(int i=1;i<n;i++)
        {
            if(nums[i]-nums[i-1]>maxDiff)
            {
                bad[i]=1;
            }
        } 
        for(int i=1;i<n;i++)
        {
            pre[i]=pre[i-1]+bad[i];
        }
        for(int i=0;i<m;i++)
        {
            int curr[]=queries[i];
            int l=curr[0];
            int r=curr[1];
            if(l>r)
            {
                int temp=l;
                l=r;
                r=temp;
            }
            res[i]=(pre[r]-pre[l]==0)?true:false;
        }
        return res;
    }
}