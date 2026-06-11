class Solution {
    public int maxArea(int[] height) {
        int l=0,h=height.length-1;
        int max=0;
        while(l<h)
        {
            if(height[l]<height[h])
            {
                max=Math.max(max,Math.min(height[l],height[h])*(h-l));
                l++;
            }
            else if(height[h]<=height[l])
            {
                max=Math.max(max,Math.min(height[l],height[h])*(h-l));
                h--;
            }
        }
        return max;
    }
}