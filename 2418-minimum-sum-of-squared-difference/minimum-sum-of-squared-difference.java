class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k=(long)k1+k2;
        int n=nums1.length;
        int cnt[]=new int[100001];
        int max_diff=0;
        for(int i=0;i<n;i++)
        {
            int diff=Math.abs(nums1[i]-nums2[i]);
            max_diff=Math.max(max_diff,diff);
            cnt[diff]++;
        }
        int i=max_diff;
        while(i>0 && k>0)
        {
            int temp=(int)Math.min(cnt[i],k);
            k=k-temp;
            cnt[i]-=temp;
            cnt[i-1]+=temp;
            i--;
        }
        long res=0;
        for(long j=1;j<=max_diff;j++)
        {
            res+=cnt[(int)j]*j*j;
        }
        return res;
    }
}