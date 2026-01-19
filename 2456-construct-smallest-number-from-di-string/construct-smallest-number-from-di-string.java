class Solution {
    public String smallestNumber(String pattern) {
        return helper(pattern);
    }
    public String helper(String s)
    {
        int count=1;
        Stack<Integer> st=new Stack<Integer>();
        st.push(count++);
        String ans="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='D')
            {
                st.push(count++);
            }
            else if(s.charAt(i)=='I')
            {
                while(st.size()!=0)
                {
                    ans+=st.pop();
                }
                st.push(count++);
            }
        }
        while(st.size()!=0)
        {
            ans+=st.pop();
        }
        return ans;
    }
}