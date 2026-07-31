class Solution {
    public int minimumPushes(String word) {
        int letter[]=new int[26];
        for(int i=0;i<word.length();i++)
        {
            char x=word.charAt(i);
            letter[x-'a']++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i=0;i<26;i++)
        {
            if(letter[i]!=0)
            {
                pq.add(letter[i]);
            }
        }
        int f=0;
        int res=0;
        while(pq.size()!=0)
        {
            int num=pq.poll();
            res+=num*((f/8)+1);
            f++;
        }
        return res;
    }
}