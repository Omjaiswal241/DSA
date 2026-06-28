class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums)
        {
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int maxlen=1;
        for(int key:hm.keySet())
        {
            int len=0;
            if(key==1)
            {
                int a=(hm.get(1)%2==0)?hm.get(1)-1:hm.get(1);
                maxlen=Math.max(a,maxlen);
                continue;
            }
            while(hm.getOrDefault(key,0)>=2)
            {
                len+=2;
                key=key*key;
            }
            if(hm.getOrDefault(key,0)==1)
            {
                len+=1;
            }
            else
            {
                len=len-1;
            }
            maxlen=Math.max(maxlen,len);
        }
        return maxlen;
    }
}