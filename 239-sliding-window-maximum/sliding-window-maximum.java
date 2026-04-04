class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int nger[]=new int[n];
        nger[n-1]=n;
        Stack<Integer> st=new Stack<>();
        st.push(n-1);
        for(int i=n-2;i>=0;i--)
        {
            while(st.size()!=0 && nums[i]>=nums[st.peek()])
            {
                st.pop();
            }
            if(st.size()==0)
            {
                nger[i]=n;
            }
            else
            {
                nger[i]=st.peek();
            }
            st.push(i);
        }
        int res[]=new int[n-k+1];
        int j=0;
        for(int i=0;i<n-k+1;i++)
        {
            if(i>j)
            {
                j=i;
            }
            while(nger[j]<i+k)
            {
                j=nger[j];
            }
            res[i]=nums[j];
        }
        return res;
    }
}