class Solution {
    public String removeStars(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            if(x=='*')
            {
                if(st.size()==0)
                {
                    continue;
                }
                else
                {
                    st.pop();
                }
            }
            else
            {
                st.push(x);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(st.size()!=0)
        {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}