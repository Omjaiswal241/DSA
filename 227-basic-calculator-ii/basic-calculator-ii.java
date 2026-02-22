class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        int num=0;
        char sign='+';
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            if(Character.isDigit(x))
            {
                num=num*10+Integer.parseInt(x+"");
            }
            if((!(Character.isDigit(x)) && x!=' ') || i==s.length()-1)
            {
                if(sign=='+')
                {
                    st.push(num);
                }
                else if(sign=='-')
                {
                    st.push(-num);
                }
                else if(sign=='*')
                {
                    st.push(st.pop()*num);
                }
                else if(sign=='/')
                {
                    st.push(st.pop()/num);
                }
                sign=x;
                num=0;
            }
        }
        int res=0;
        for(int val:st)
        {
            res+=val;
        }
        return res;
    }
}