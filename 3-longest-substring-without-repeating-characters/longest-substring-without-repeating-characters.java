class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        int start=0;
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            while(start<=i && hm.containsKey(x))
            {
                hm.remove(s.charAt(start));
                start++;
            }
            hm.put(x,1);
            res=Math.max(res,i-start+1);
        }
        return res;
    }
}