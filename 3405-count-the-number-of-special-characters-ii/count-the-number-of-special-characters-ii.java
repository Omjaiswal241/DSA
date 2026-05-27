class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character,ArrayList<Integer>> hm=new HashMap<>();
        for(int i=0;i<word.length();i++)
        {
            char x=word.charAt(i);
            ArrayList<Integer> li=hm.getOrDefault(x,new ArrayList<>());
            li.add(i);
            hm.put(x,li);
        }
        int cnt=0;
        for(char x:hm.keySet())
        {
            if(Character.isLowerCase(x))
            {
                ArrayList<Integer> a=hm.get(x);
                if(hm.containsKey(Character.toUpperCase(x)))
                {
                    ArrayList<Integer> b=hm.get(Character.toUpperCase(x));
                    if(b.get(0)-a.get(a.size()-1)>0)
                    {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}