class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        int cnt=0;
        int other=0;
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            if(x=='(')
            {
                cnt++;
            }
            else
            {
                if(cnt>0)
                {
                    cnt--;
                }
                else
                {
                    other++;
                }
            }
        }
        return other+cnt;
    }
}