class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> qu=new ArrayDeque<>();
        for(int i=1;i<=9;i++)
        {
            qu.add(i);
        }
        List<Integer> res=new ArrayList<>();
        while(qu.size()!=0)
        {
            int a=qu.poll();
            if(a>=low && a<=high)
            {
                res.add(a);
            }
            int last_dig=a%10;
            if(last_dig<9)
            {
                int num=a*10+(last_dig+1);
                if(num<=high)
                {
                    qu.add(num);
                }
            }
        }
        return res;
    }
}