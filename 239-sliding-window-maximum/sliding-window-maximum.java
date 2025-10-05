class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        // if(n==0 && k==0)
        // {
        // return new int[0];
        // }
        int nger[]=new int[n];
        int res[]=new int[n-k+1];
        Stack<Integer> st=new Stack<>();
        st.push(n-1);
        nger[n-1]=n;
        for(int i=nums.length-2;i>=0;i--)
        {
            while(st.size()>0 && nums[st.peek()]<nums[i])
            {
                st.pop();
            }
            if(st.size()==0)
            {
                nger[i]=n;
            }
            else{
                nger[i]=st.peek();
            }
            st.push(i);
        }
        for(int i=0;i<res.length;i++)
        {
            int j=i;
            while(nger[j]<i+k)
            {
                j=nger[j];
            }
            res[i]=nums[j];
        }
        return res;
    }
}