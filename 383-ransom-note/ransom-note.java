class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int hash[]=new int[26];
        for(int i=0;i<magazine.length();i++)
        {
            char x=magazine.charAt(i);
            hash[x-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++)
        {
            char a=ransomNote.charAt(i);
            hash[a-'a']--;
        }
        for(int i=0;i<26;i++)
        {
            if(hash[i]<0)
            {
                return false;
            }
        }
        return true;
    }
}