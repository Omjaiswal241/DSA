class Solution {
    public int trap(int[] height) {
        int n=height.length;
       int premax=height[0];
       int [] prefix=new int[n];
       prefix[0]=height[0];
       for(int i=1;i<n;i++)
       {
        premax=Math.max(premax,height[i]);
        prefix[i]=premax;
       }
       int suffmax=height[n-1];
       int [] suffix=new int[n];
       suffix[n-1]=height[n-1];
       for(int i=n-2;i>=0;i--)
       {
        suffmax=Math.max(suffmax,height[i]);
        suffix[i]=suffmax;
       }
       int total=0;
       for(int i=0;i<n;i++)
       {
        int leftmax=prefix[i];
        int rightmax=suffix[i];
        if(height[i]<leftmax && height[i]<rightmax)
        {
            total+=Math.min(leftmax,rightmax)-height[i];
        }
       }
       return total; 
    }
}