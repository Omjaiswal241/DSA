class Solution {
    class Pair implements Comparable<Pair>
    {
        int num,freq;
        Pair(int num,int freq)
        {
            this.num=num;
            this.freq=freq;
        }
        public int compareTo(Pair o)
        {
            return this.freq-o.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int key:hm.keySet())
        {
            int freq=hm.get(key);
            pq.add(new Pair(key,freq));
            if(pq.size()>k)
            {
                pq.remove();
            }
        }
        int res[]=new int[k];
        while(k>0)
        {
            res[k-1]=pq.remove().num;
            k--;
        }
        return res;
    }
}