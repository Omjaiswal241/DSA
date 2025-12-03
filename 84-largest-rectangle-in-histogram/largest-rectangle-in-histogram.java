class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int prev[]=new int[n];
        int nse[]=new int[n];
        Stack<Integer> st1=new Stack<Integer>();
        nse[n-1]=n;
        st1.push(n-1);
        for(int i=n-2;i>=0;i--)
        {
            while(st1.size()>0 && heights[st1.peek()]>=heights[i])
            {
                st1.pop();
            }
            if(st1.size()==0)
            {
                nse[i]=n;
            }
            else
            {
            nse[i]=st1.peek();
            }
            st1.push(i);
        }
        Stack<Integer> st2=new Stack<>();
        prev[0]=-1;
        st2.push(0);
        for(int i=1;i<n;i++)
        {
            while(st2.size()>0 && heights[st2.peek()]>=heights[i])
            {
                st2.pop();
            }
            if(st2.size()==0)
            {
                prev[i]=-1;
            }
            else
            {
                prev[i]=st2.peek();
            }
            st2.push(i);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int size=nse[i]-prev[i]-1;
            max=Math.max(max,size*heights[i]);
        }
        return max;
    }
}