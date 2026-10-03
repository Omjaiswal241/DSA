class Solution {
    public int longestValidParentheses(String s) {
        int n=s.length();
        int max_len=0;
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            if(x=='(')
            {
                st.push(i);
            }
            else
            {     
                st.pop();
                if(st.size()==0)
                {
                    st.push(i);
                }
                else
                {
                    max_len=Math.max(max_len,i-st.peek());
                }
            }
        }
        return max_len;
    }
}