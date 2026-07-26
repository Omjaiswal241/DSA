class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        int open=0;
        int close=0;
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            char y=s.charAt(n-1-i);
            if(x=='(' || x=='*')
            {
                open++;
            }
            else if(x==')')
            {
                open--;
                if(open<0)
                {
                    return false;
                }
            }
            if(y==')' || y=='*')
            {
                close++;
            }
            else if(y=='(')
            {
                close--;
                if(close<0)
                {
                    return false;
                }
            }
        }
        return true;
    }
}