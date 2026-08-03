class Solution {
    class Pair implements Comparable<Pair>
    {
        int first,sec,sum;
        Pair(int first,int sec,int sum)
        {
            this.first=first;
            this.sec=sec;
            this.sum=sum;
        }
        public int compareTo(Pair o)
        {
            return Integer.compare(o.sum,this.sum);
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int n=nums1.length;
        int m=nums2.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(pq.size()<k)
                {
                    pq.add(new Pair(nums1[i],nums2[j],nums1[i]+nums2[j]));
                }
                else
                {
                    if(pq.peek().sum>nums1[i]+nums2[j])
                    {
                        pq.poll();
                        pq.add(new Pair(nums1[i],nums2[j],nums1[i]+nums2[j]));
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        while(pq.size()!=0)
        {
            Pair curr=pq.poll();
            res.addFirst(new ArrayList<>());
            res.get(0).add(curr.first);
            res.get(0).add(curr.sec);
        }
        return res;
    }
}