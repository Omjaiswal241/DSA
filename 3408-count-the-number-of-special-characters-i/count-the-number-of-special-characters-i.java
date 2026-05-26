class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<word.length();i++)
        {
            char x=word.charAt(i);
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        int cnt=0;
        for(char ch:hm.keySet())
        {
            if(Character.isLowerCase(ch))
            {
                if(hm.containsKey(Character.toUpperCase(ch)))
                {
                    cnt++;
                }
            }
            else
            {
                if(hm.containsKey(Character.toLowerCase(ch)))
                {
                    cnt++;
                }
            }
        }
        return cnt/2;
    }
}