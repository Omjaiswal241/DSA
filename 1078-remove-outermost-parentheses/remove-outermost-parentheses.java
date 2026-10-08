class Solution {
    public String removeOuterParentheses(String s) {
        int n=s.length();
        int cnt=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            if(cnt==0)
            {
                cnt++;
                continue;
            }
            else
            {
                if(x=='(')
                {
                    cnt++;
                }
                else
                {
                    cnt--;
                }
                if(cnt!=0)
                {
                    sb.append(x);
                }
            }
        }
        return sb.toString();
    }
}