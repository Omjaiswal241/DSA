class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int hash[]=new int[26];
        for(int i=0;i<tasks.length;i++)
        {
            char x=tasks[i];
            hash[x-'A']++;
        }
        for(int i=0;i<26;i++)
        {
            if(hash[i]!=0)
            {
                pq.add(hash[i]);
            }
        }
        int res=0;
        while(pq.size()!=0)
        {
            List<Integer> li=new ArrayList<>();
            for(int i=1;i<=n+1;i++)
            {
                if(pq.size()!=0)
                {
                    int freq=pq.poll();
                    freq--;
                    li.add(freq);
                }
            }
            for(int i=0;i<li.size();i++)
            {
                if(li.get(i)!=0)
                {
                    pq.add(li.get(i));
                }
            }
            if(pq.size()==0)
            {
                res+=li.size();
            }
            else
            {
                res+=n+1;
            }
        }
        return res;
    }
}