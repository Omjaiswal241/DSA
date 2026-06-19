class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int n=stones.length;
        for(int i=0;i<n;i++)
        {
            pq.add(stones[i]);
        }
        while(pq.size()>1)
        {
            int a=pq.remove();
            int b=pq.remove();
            int c=a-b;
            pq.add(c);
        }
        return pq.remove();
    }
}