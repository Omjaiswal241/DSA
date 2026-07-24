class Solution {
    class Pair
    {
        int num;
        int freq;
        Pair(int num,int freq)
        {
            this.num=num;
            this.freq=freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int num:nums)
        {
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->
        {
            return a.freq-b.freq;
        });
        for(int key:hm.keySet())
        {
            if(pq.size()<k)
            {
                pq.add(new Pair(key,hm.get(key)));
            }
            else
            {
                if(hm.get(key)>pq.peek().freq)
                {
                    pq.poll();
                    pq.add(new Pair(key,hm.get(key)));
                }
            }
        }
        int res[]=new int[k];
        int i=0;
        while(pq.size()>0)
        {
            res[i++]=pq.poll().num;
        }
        return res;
    }
}