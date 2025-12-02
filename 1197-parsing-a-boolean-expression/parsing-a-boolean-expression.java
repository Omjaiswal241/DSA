class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<expression.length();i++)
        {
            char x=expression.charAt(i);
            if(x==',')
            {
                continue;
            }
            else if(x==')')
            {
                ArrayList<Character> li=new ArrayList<>();
                while(st.peek()!='(')
                {
                    char f=st.pop();
                    li.add(f);
                }
            st.pop();
            char op=st.pop();
            char res=solve(li,op);
            st.push(res);
            }
            else
            {
                st.push(x);
            }
        }
        return st.pop()=='t'?true:false;
    }
    public static char solve(ArrayList<Character> li,char op)
    {
        if(op=='!')
        {
            return li.get(0)=='t'?'f':'t';
        }
        else if(op=='&')
        {
            for(int i=0;i<li.size();i++)
            {
                if(li.get(i)=='f')
                {
                    return 'f';
                }
            }
            return 't';
        }
        else if(op=='|')
        {
            for(int i=0;i<li.size();i++)
            {
                if(li.get(i)=='t')
                {
                    return 't';
                }
            }
            return 'f';
        }
        return 't';
    }
}