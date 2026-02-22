class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        int num=0,res=0,sign=1;
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            if(Character.isDigit(x))
            {
                num=num*10+Integer.parseInt(x+"");
                continue;
            }
            if(x=='+')
            {
                res+=sign*num;
                num=0;
                sign=1;
            }
            else if(x=='-')
            {
                res+=sign*num;
                num=0;
                sign=-1;
            }
            if(x=='(')
            {
                st.push(res);
                st.push(sign);
                res=0;
                sign=1;
            }
            if(x==')')
            {
                res+=sign*num;
                num=0;
                int prev_sign=st.pop();
                int prev_res=st.pop();
                res=res*prev_sign+prev_res;
            }
        }
        res+=sign*num;
        return res;
    }
}