class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st=new Stack<>();
        Stack<Integer> asterisk=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            if(x=='(')
            {
                st.push(i);
            }
            else if(x==')')
            {
                if(st.size()!=0)
                {
                    st.pop();
                }
                else if(asterisk.size()!=0)
                {
                    asterisk.pop();
                }
                else
                {
                    return false;
                }
            }
            else
            {
                asterisk.push(i);
            }
        }
        while(st.size()!=0 && asterisk.size()!=0)
        {
            if(st.peek()>asterisk.peek())
            {
                return false;
            }
            st.pop();
            asterisk.pop();
        }
        return st.size()==0;
    }
}