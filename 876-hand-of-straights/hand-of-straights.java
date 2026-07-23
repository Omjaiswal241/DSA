class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0)
        {
            return false;
        }
        TreeMap<Integer,Integer> hm=new TreeMap<>();
        for(int i=0;i<n;i++)
        {
            hm.put(hand[i],hm.getOrDefault(hand[i],0)+1);
        }
        while(hm.size()!=0)
        {
            int f=hm.firstKey();
            hm.put(f,hm.get(f)-1);
            if(hm.get(f)==0)
            {
                hm.remove(f);
            }
            for(int j=1;j<groupSize;j++)
            {
                if(!hm.containsKey(f+1))
                {
                    return false;
                }
                else
                {
                    hm.put(f+1,hm.get(f+1)-1);
                    if(hm.get(f+1)==0)
                    {
                        hm.remove(f+1);
                    }
                    f++;
                }
            }
        }
        return true;
    }
}