class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s,k);
    }
    public static int helper(String s,int k)
    {
        if(s.length()<k)
        {
            return 0;
        }
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            freq[x-'a']++;
        }
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            if(freq[x-'a']<k)
            {
                int left=helper(s.substring(0,i),k);
                int right=helper(s.substring(i+1),k);
                return Math.max(left,right);
            }
        }
        return s.length();
    }
}