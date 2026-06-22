class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> hm=new HashMap<>();
        hm.put('b',0);
        hm.put('a',0);
        hm.put('l',0);
        hm.put('o',0);
        hm.put('n',0);
        for(int i=0;i<text.length();i++)
        {
            char x=text.charAt(i);
            if(hm.containsKey(x))
            {
                hm.put(x,hm.get(x)+1);
            }
        }
        if(hm.get('l')<2 || hm.get('o')<2)
        {
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for(char key:hm.keySet())
        {
            int freq=hm.get(key);
            {
                if(key=='o' || key=='l')
                {
                if(freq/2<min)
                {
                    min=freq/2;
                }
                }
                else
                {
                if(freq<min)
                {
                    min=freq;
                }
                }
            }
        }
        return min;
    }
}