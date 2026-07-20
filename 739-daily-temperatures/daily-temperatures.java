class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<Integer> st=new Stack<>();
        st.push(n-1);
        int res[]=new int[n];
        res[n-1]=0;
        int i=n-2;
        while(i>=0)
        {
            while(st.size()!=0 && temperatures[st.peek()]<=temperatures[i])
            {
                st.pop();
            }
            if(st.size()==0)
            {
                res[i]=0;
            }
            else
            {
                res[i]=st.peek()-i;
            }
            st.push(i);
            i--;
        }
        return res;
    }
}