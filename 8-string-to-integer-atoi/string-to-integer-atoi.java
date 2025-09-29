class Solution {
    public int myAtoi(String s) {
       s=s.trim();
       if(s.length()==0)
       {
        return 0;
       }
       int n=s.length();
       int sign=1;
       int i=0;
       long num=0;
       if(s.charAt(i)=='-' || s.charAt(i)=='+')
       {
        if(s.charAt(i)=='+')
        {
            sign=1;
            i++;
        }
        else if(s.charAt(i)=='-'){
            sign=-1;
            i++;
        }
       }
       while(i<n && Character.isDigit(s.charAt(i)))
       {
        num=num*10+(s.charAt(i)-'0');
        i++;
        if(num*sign>Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }
        if(num*sign<Integer.MIN_VALUE)
        {
            return Integer.MIN_VALUE;
        }
       }
       return (int)(sign*num);
    }
}