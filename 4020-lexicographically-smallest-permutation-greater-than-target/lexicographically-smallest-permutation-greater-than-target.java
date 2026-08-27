class Solution {
    String res="";
    public String lexGreaterPermutation(String s, String target) {
        int cnt[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            cnt[x-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        solve(cnt,sb,target,0,false);
        return res;
    }
    public boolean solve(int cnt[],StringBuilder sb,String target,int idx,boolean greater)
    {
        if(idx==target.length())
        {
            if(greater)
            {
                res=sb.toString();
                return true;
            }
            return false;
        }
        for(char ch='a';ch<='z';ch++)
        {
            if(cnt[ch-'a']==0)
            {
                continue;
            }
            if(greater==false && ch<target.charAt(idx))
            {
                continue;
            }
            sb.append(ch);
            cnt[ch-'a']--;
            boolean isgreater=greater || ch>target.charAt(idx);
            if(solve(cnt,sb,target,idx+1,isgreater))
            {
                return true;
            }
            sb.deleteCharAt(sb.length()-1);
            cnt[ch-'a']++;
        }
        return false;
    }
}