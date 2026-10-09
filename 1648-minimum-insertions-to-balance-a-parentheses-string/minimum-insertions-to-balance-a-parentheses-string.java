class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        int i=0;
        int res=0,cnt=0;
        while(i<n)
        {
            char x=s.charAt(i);
            if(x=='(')
            {
                cnt++;
                i++;
            }
            else
            {
                if(cnt>0)
                {
                    cnt--;
                }
                else
                {
                    res++;
                }
                if(i>s.length()-2 || s.charAt(i+1)!=')')
                {
                    res++;
                    i++;
                }
                else
                {
                    i=i+2;
                }
            }
        }
        return res+cnt*2;
    }
}