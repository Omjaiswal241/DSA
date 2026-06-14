class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int res[]=new int[n-k+1];
        Stack<Integer> st=new Stack<>();
        st.push(n-1);
        int i=n-2;
        int nger[]=new int[n];
        nger[n-1]=n;
        while(i>=0)
        {
            while(st.size()>0 && nums[st.peek()]<=nums[i])
            {
                st.pop();
            }
            if(st.size()==0)
            {
                st.push(i);
                nger[i]=n;
            }
            else
            {
                nger[i]=st.peek();
                st.push(i);
            }
            i--;
        }
        for(int j=0;j<n-k+1;j++)
        {
            int f=j;
            int prev=j;
            while(f<j+k)
            {
                prev=f;
                f=nger[f];
            }
            res[j]=nums[prev];
        }
        return res;
    }
}