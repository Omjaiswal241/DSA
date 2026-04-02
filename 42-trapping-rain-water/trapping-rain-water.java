class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int pre[]=new int[n];
        for(int i=1;i<n;i++)
        {
            int a=Math.max(pre[i-1],height[i-1]);
            pre[i]=(a>height[i])?a:0;
        }
        int []suff=new int[n];
        for(int i=n-2;i>=0;i--)
        {
            int b=Math.max(suff[i+1],height[i+1]);
            suff[i]=(b>height[i])?b:0;
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            int c=(Math.min(pre[i],suff[i])!=0)?Math.min(pre[i],suff[i])-height[i]:0;
            ans+=c;
        }
        return ans;
    }
}