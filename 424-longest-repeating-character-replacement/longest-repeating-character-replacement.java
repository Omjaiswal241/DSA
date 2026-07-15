class Solution {
    public int characterReplacement(String s, int k) {
        int hash[]=new int[26];
        int n=s.length();
        int l=0,h=0,maxfreq=0;
        int maxlen=0;
        while(h<n)
        {
            char x=s.charAt(h);
            hash[x-'A']++;
            maxfreq=Math.max(maxfreq,hash[x-'A']);
            if((h-l+1)-maxfreq>k)
            {
                char z=s.charAt(l);
                hash[z-'A']--;
                l++;
            }
            else
            {
                maxlen=Math.max(maxlen,h-l+1);
            }
            h++;
        }
        return maxlen;
    }
}