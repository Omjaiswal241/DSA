class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> openBracket=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            if(x=='(')
            {
                openBracket.push(sb.length());
            }
            else if(x==')')
            {
                int start_idx=openBracket.pop();
                reverse(sb,start_idx,sb.length()-1);
            }
            else
            {
                sb.append(x);
            }
        }
        return sb.toString();
    }
    public void reverse(StringBuilder sb,int low,int high)
    {
        while(low<high)
        {
            char temp=sb.charAt(low);
            sb.setCharAt(low++,sb.charAt(high));
            sb.setCharAt(high--,temp);
        }
    }
}