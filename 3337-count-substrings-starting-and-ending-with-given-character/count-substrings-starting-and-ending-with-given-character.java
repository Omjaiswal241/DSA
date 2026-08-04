class Solution {
    public long countSubstrings(String s, char c) {
        long res=0;
        long cnt=0;
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            if(x==c)
            {
                res+=1;
                res+=cnt;
                cnt++;
            }
        }
        return res;
    }
}