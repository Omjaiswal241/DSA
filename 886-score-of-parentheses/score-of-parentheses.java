class Solution {
    public int scoreOfParentheses(String s) {
        int n=s.length();
        int depth=0;
        int res=0;
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            if(x=='(')
            {
                depth++;
            }
            else
            {
                depth--;
                if(s.charAt(i-1)=='(')
                {
                res+=(1<<depth);
                }
            }
        }
        return res;
    }
}