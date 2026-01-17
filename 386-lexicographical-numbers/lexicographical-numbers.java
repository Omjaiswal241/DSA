class Solution {
    List<Integer> res=new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for(int i=1;i<=9;i++)
        {
            if(i<=n)
            {
            helper(n,i);
            }
        }
        return res;
    }
    public void helper(int n,int i)
    {
        res.add(i);
        for(int j=0;j<=9;j++)
        {
            int f=i*10+j;
            if(f<=n)
            {
                helper(n,f);
            }
        }
    }
}