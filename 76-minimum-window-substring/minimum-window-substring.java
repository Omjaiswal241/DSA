class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<t.length();i++)
        {
            char ch=t.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int i=0,j=0;
        int cntreq=t.length();
        int startidx=0;
        int minlen=Integer.MAX_VALUE;
        while(j<n)
        {
            char x=s.charAt(j);
            if(hm.containsKey(x) && hm.get(x)>0)
            {
                cntreq--;
            }
            hm.put(x,hm.getOrDefault(x,0)-1);
            while(i<=j && cntreq==0)
            {
                if(j-i+1<minlen)
                {
                    minlen=(j-i+1);
                    startidx=i;
                }
                char a=s.charAt(i);
                hm.put(a,hm.get(a)+1);
                if(hm.get(a)>0)
                {
                    cntreq++;
                }
                i++;
            }
            j++;
        }
        return minlen==Integer.MAX_VALUE?"":s.substring(startidx,startidx+minlen);
    }
}