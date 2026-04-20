class Solution {
    public int maxDistance(int[] colors) {
        int res=0;
        int n=colors.length;
        for(int i=0;i<n;i++)
        {
            if(colors[i]!=colors[0])
            {
                res=Math.max(i-0,res);
            }
            if(colors[i]!=colors[n-1])
            {
                res=Math.max(n-i-1,res);
            }
        }
        return res;
    }
}