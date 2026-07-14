class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        int i=0,j=0,maxlen=0;
        int n=s.length();
        while(i<n)
        {
            char x=s.charAt(i);
            if(hm.containsKey(x))
            {
                while(j<i && hm.containsKey(x))
                {
                    char f=s.charAt(j);
                    hm.remove(f);
                    j++;
                }
            }
            hm.put(x,0);
            maxlen=Math.max(maxlen,i-j+1);
            i++;
        }
        return maxlen;
    }
}