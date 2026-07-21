class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int activecounts=0;
        int n=s.length();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                activecounts++;
            }
        }
        int i=0;
        List<Integer> li=new ArrayList<>();
        while(i<n)
        {
            char x=s.charAt(i);
            if(x=='0')
            {
                int start=i;
                while(i<n && s.charAt(i)=='0')
                {
                    i++;
                }
                li.add(i-start);
            }
            else
            {
                i++;
            }
        }
        int maxPairs=0;
        for(int j=1;j<li.size();j++)
        {
            maxPairs=Math.max(maxPairs,li.get(j)+li.get(j-1));
        }
        return maxPairs+activecounts;
    }
}