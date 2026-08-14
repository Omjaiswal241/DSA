class Solution {
    public int maximumLengthSubstring(String s) {
        int letter[]=new int[26];
        int res=0;
        int j=0;
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            letter[x-'a']++;
            while(letter[x-'a']>2)
            {
                char f=s.charAt(j);
                letter[f-'a']--;
                j++;
            }
            res=Math.max(res,i-j+1);
        }
        return res;
    }
}