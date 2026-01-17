class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0,end=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        int maxlen=0;
        while(end<s.length())
        {
            char x=s.charAt(end);
            while(start<=end && hm.containsKey(x))
            {
                hm.remove(s.charAt(start));
                start++;
            }
            hm.put(x,1);
            maxlen=Math.max(maxlen,end-start+1);
            end++;
        }
        return maxlen;
    }
}