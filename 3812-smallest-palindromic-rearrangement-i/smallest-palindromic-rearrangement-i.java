class Solution {
    public String smallestPalindrome(String s) {
        TreeMap<Character,Integer> tm=new TreeMap<>();
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            tm.put(x,tm.getOrDefault(x,0)+1);
        }
        StringBuilder sb=new StringBuilder();
        for(char key:tm.keySet())
        {
            int freq=tm.get(key)/2;
            for(int i=1;i<=freq;i++)
            {
                sb.append(key);
            }
            tm.put(key,tm.get(key)%2);
        }
        String mid="";
        for(char key:tm.keySet())
        {
            if(tm.get(key)!=0)
            {
                mid=key+"";
                break;
            }
        }
        String ans=sb.toString();
        String rev=sb.reverse().toString();
        return ans+mid+rev;
    }
}