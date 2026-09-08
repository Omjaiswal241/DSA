class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<t.length();i++)
        {
            char x=t.charAt(i);
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        int i=0,j=0;
        int cnt=t.length();
        int n=s.length();
        String res="";
        int len=Integer.MAX_VALUE;
        while(i<n)
        {
            char x=s.charAt(i);
            if(hm.getOrDefault(x,0)>0)
            {
            cnt--;
            }
            hm.put(x,hm.getOrDefault(x,0)-1);
            while(cnt==0)
            {
                if(len>(i-j+1))
                {
                    len=(i-j+1);
                    res=s.substring(j,i+1);
                }
                char y=s.charAt(j);
                hm.put(y,hm.get(y)+1);
                j++;
                if(hm.get(y)>0)
                {
                    cnt++;
                }
            }
            i++;
        }
        return res;
    }
}